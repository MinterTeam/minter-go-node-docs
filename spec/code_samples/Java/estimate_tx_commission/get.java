package network.minter.blockchain.samples.estimate_tx_commission;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

import network.minter.blockchain.MinterBlockChainApi;
import network.minter.blockchain.models.BCResult;
import network.minter.blockchain.models.ExchangeSellValue;
import network.minter.blockchain.models.TransactionCommissionValue;
import network.minter.blockchain.models.operational.TransactionSign;
import network.minter.blockchain.repo.BlockChainCoinRepository;
import network.minter.blockchain.repo.BlockChainTransactionRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class get {

    public static void main(String[] args) {
        MinterBlockChainApi.initialize("https://minter-node-1.testnet.minter.network:8841");

        BlockChainTransactionRepository repository = MinterBlockChainApi.getInstance().transactions();

        String sign = "..."; // signed transaction hash started without 0x
        Call<BCResult<TransactionCommissionValue>> request = repository.getTransactionCommission("");


        request.enqueue(new Callback<BCResult<TransactionCommissionValue>>() {
            @Override
            public void onResponse(@NotNull Call<BCResult<TransactionCommissionValue>> call, @NotNull Response<BCResult<TransactionCommissionValue>> response) {
                BCResult<TransactionCommissionValue> body = response.body();
                if(body.isOk()) {
                    // do something with body.result
                } else {
                    Log.d("MinterError", body.error.getMessage());
                }
            }

            @Override
            public void onFailure(@NotNull Call<BCResult<TransactionCommissionValue>> call, @NotNull Throwable t) {
                // handle error
            }
        });
    }
}
