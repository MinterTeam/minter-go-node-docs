package network.minter.blockchain.samples.estimate_coin_sell;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

import network.minter.blockchain.MinterBlockChainApi;
import network.minter.blockchain.models.BCResult;
import network.minter.blockchain.models.ExchangeBuyValue;
import network.minter.blockchain.models.ExchangeSellValue;
import network.minter.blockchain.repo.BlockChainCoinRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class get {

    public static void main(String[] args) {
        MinterBlockChainApi.initialize("https://minter-node-1.testnet.minter.network:8841");

        BlockChainCoinRepository repository = MinterBlockChainApi.getInstance().coin();
        Call<BCResult<ExchangeSellValue>> request = repository.getCoinExchangeCurrencyToSell(
                "MNT",
                new BigDecimal("10"),
                "TESTCOIN");


        request.enqueue(new Callback<BCResult<ExchangeSellValue>>() {
            @Override
            public void onResponse(@NotNull Call<BCResult<ExchangeSellValue>> call, @NotNull Response<BCResult<ExchangeSellValue>> response) {
                BCResult<ExchangeSellValue> body = response.body();
                if(body.isOk()) {
                    // do something with body.result
                } else {
                    Log.d("MinterError", body.error.getMessage());
                }
            }

            @Override
            public void onFailure(@NotNull Call<BCResult<ExchangeSellValue>> call, @NotNull Throwable t) {
                // handle error
            }
        });
    }
}
