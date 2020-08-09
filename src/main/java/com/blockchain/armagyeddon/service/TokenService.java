package com.blockchain.armagyeddon.service;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.blockchain.armagyeddon.domain.entity.UserInfo;
import com.blockchain.armagyeddon.domain.repository.UserInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;

import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.protocol.Web3j;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalListAccounts;

import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthCall;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.http.HttpService;

@Service
@Transactional
public class TokenService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    // Token contract address
    private String armaTokenAddress = "0x7e60cfc13D73E715e1515253B4A39A0925a16DB3";
    private String networkAddress = "http://127.0.0.1:7545";
    private Web3j web3j;

    private Admin admin;
    List<String> addressList;

    // Connect blockchain server with web3j
    public TokenService() throws Exception {
        web3j = Web3j.build(new HttpService(networkAddress));
        admin = Admin.build(new HttpService(networkAddress));

        PersonalListAccounts personalListAccounts = admin.personalListAccounts().send();

        addressList = personalListAccounts.getAccountIds();

    }

    // connect function
    private List<Type> noTransactionFunction(String functionName, List<Type> inputParameters,
            List<TypeReference<?>> outputParameters) throws IOException {

        Function function = new Function(functionName, inputParameters, outputParameters);

        System.out.println("function : " + function);

        // send transaction from address[0] to contract
        Transaction transaction = Transaction.createEthCallTransaction(addressList.get(0), armaTokenAddress,
                FunctionEncoder.encode(function));


        EthCall ethCall = web3j.ethCall(transaction, DefaultBlockParameterName.LATEST).send();

     

        List<Type> decode = FunctionReturnDecoder.decode(ethCall.getResult(), function.getOutputParameters());

        return decode;
    }

    // Get total supplied token
    public String totalSupply() throws Exception {

        List<Type> decode = noTransactionFunction("totalSupply", Collections.emptyList(),
                Arrays.asList(new TypeReference<Uint256>() {
                }));

        return decode.get(0).getValue().toString();

    }

    // Get email user's balance
    public String getBalance(String email) throws Exception {

        String balance;
        UserInfo targetUser = userInfoRepository.findByEmail(email);

        if (targetUser == null)
            return "user [" + email + "] didn't exist";

        String address = targetUser.getPublic_key();

        System.out.println(address);

        List<Type> decode = noTransactionFunction("balanceOf", Arrays.asList(new Address(address)),
                Arrays.asList(new TypeReference<Uint256>() {
                }));
        balance = decode.get(0).getValue().toString();

        return balance;

    }

    public String chargeToken(String email, String amount) {

        UserInfo targetUser = userInfoRepository.findByEmail(email);
        BigInteger amount_ = new BigInteger(amount);

        if (targetUser == null)
            return "user [" + email + "] didn't exist";

        String address = targetUser.getPublic_key();

        System.out.println("user address : " + address);

        List<Type> inputParameters = new ArrayList<>();
        inputParameters.add(new Address(address));
        inputParameters.add(new Uint256(amount_));

        Function function = new Function("mint", inputParameters,
                Collections.emptyList());

        EthGetTransactionCount ethGetTransactionCount = null;

        try {
            ethGetTransactionCount = web3j.ethGetTransactionCount(addressList.get(0), DefaultBlockParameterName.LATEST)
                    .sendAsync().get();
        } catch (InterruptedException | ExecutionException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        BigInteger nonce = ethGetTransactionCount.getTransactionCount();
        Transaction transaction = Transaction.createFunctionCallTransaction(addressList.get(0), nonce,
                Transaction.DEFAULT_GAS, null, armaTokenAddress, FunctionEncoder.encode(function));

        EthSendTransaction ethSendTransaction = null;
        try {
            ethSendTransaction = web3j.ethSendTransaction(transaction).send();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        // ledger에 쓰여지기 까지 기다리기.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        

        return "good";

    }

    
    
    
}