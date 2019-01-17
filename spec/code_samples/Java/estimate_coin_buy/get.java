package network.minter.blockchain.samples.estimate_coin_buy;

import android.util.Log;

import java.math.BigDecimal;

import javax.annotation.Nonnull;

import network.minter.blockchain.MinterBlockChainApi;
import network.minter.blockchain.models.BCResult;
import network.minter.blockchain.models.ExchangeBuyValue;
import network.minter.blockchain.repo.BlockChainCoinRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class get {

    public static void main(String[] args) {
        MinterBlockChainApi.initialize("https://minter-node-1.testnet.minter.network:8841");

        BlockChainCoinRepository repository = MinterBlockChainApi.getInstance().coin();
        Call<BCResult<ExchangeBuyValue>> request = repository.getCoinExchangeCurrencyToBuy(
                "MNT",
                new BigDecimal("10"),
                "TESTCOIN");


        request.enqueue(new Callback<BCResult<ExchangeBuyValue>>() {
            @Override
            public void onResponse(@Nonnull Call<BCResult<ExchangeBuyValue>> call, @Nonnull Response<BCResult<ExchangeBuyValue>> response) {
                BCResult<ExchangeBuyValue> body = response.body();
                if (body.isOk()) {
                    // do something with body.result
                } else {
                    Log.d("MinterError", body.error.getMessage());
                }
            }

            @Override
            public void onFailure(@Nonnull Call<BCResult<ExchangeBuyValue>> call, @Nonnull Throwable t) {
                // handle error
            }
        });
    }
}
