package com.blockchain.armagyeddon.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    private List<Type> setAndGetResultFunction(String functionName, List<Type> inputParameters,
            List<TypeReference<?>> outputParameters) throws IOException {
        
        Function function = new Function(functionName, inputParameters, outputParameters);

        System.out.println("function : " + function);

        // send transaction from address[0] to contract
        Transaction transaction = Transaction.createEthCallTransaction(addressList.get(0),
            armaTokenAddress, FunctionEncoder.encode(function));

        System.out.println("transaction : " + transaction);
        
        System.out.println("data : " + transaction.getData());

        System.out.println("from : " + transaction.getFrom());
        

        EthCall ethCall = web3j.ethCall(transaction, DefaultBlockParameterName.LATEST).send();
        
        System.out.println("ethCall : " + ethCall.getResult());

        List<Type> decode = FunctionReturnDecoder.decode(ethCall.getResult(), function.getOutputParameters());

        return decode;
    }


    // Get total supplied token
    public String totalSupply() throws Exception {

        List<Type> decode = setAndGetResultFunction("totalSupply", 
            Collections.emptyList(), Arrays.asList(new TypeReference<Uint256>(){}));
        
        return decode.get(0).getValue().toString();
   
    }

    // Get email user's balance
    public String getBalance(String email) throws Exception {

        String balance;
        UserInfo targetUser = userInfoRepository.findByEmail(email);

        if(targetUser == null)
            return "user [" + email + "] didn't exist";

        String address = targetUser.getPublic_key();
        
        System.out.println(address);

        List<Type> decode = setAndGetResultFunction("balanceOf",
            Arrays.asList(new Address(address)), Arrays.asList(new TypeReference<Uint256>(){}));
        balance = decode.get(0).getValue().toString();
        
        return balance;
        
    }

    public String chargeToken(String email, int amount) throws IOException {

        UserInfo targetUser = userInfoRepository.findByEmail(email);

        if(targetUser == null)
            return "user [" + email + "] didn't exist";

        String address = targetUser.getPublic_key();

        System.out.println("user address : " + address);

        setAndGetResultFunction("mint", 
            Arrays.asList(new Address(address), new Uint256(amount)), Collections.emptyList());


        return "good";

    }
}