package com.blockchain.armagyeddon.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    String armaTokenAddress = "0xB402c4bD78746Cb902d706a30C1BA52C38a6eFe6";
    String networkAddress = "http://127.0.0.1:7545";
    Web3j web3j;

    Admin admin;
    List<String> addressList;
    
   public TokenService() throws Exception {
       web3j = Web3j.build(new HttpService(networkAddress));
       admin = Admin.build(new HttpService(networkAddress));

        PersonalListAccounts personalListAccounts
            = admin.personalListAccounts().send();

        addressList = personalListAccounts.getAccountIds();
   }


   public String totalSupply() throws Exception {
   
        Function function = new Function("totalSupply", 
            Collections.emptyList(), Arrays.asList(new TypeReference<Uint256>(){}));

        
        Transaction transaction = Transaction.createEthCallTransaction(addressList.get(0),
            armaTokenAddress, FunctionEncoder.encode(function));
        
        EthCall ethCall = web3j.ethCall(transaction, DefaultBlockParameterName.LATEST).send();
        
        List<Type> decode = FunctionReturnDecoder.decode(ethCall.getResult(), function.getOutputParameters());
   
        return decode.get(0).getValue().toString();
   
    }
}