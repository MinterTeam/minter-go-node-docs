package network.minter.blockchain.samples.coin_info;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import network.minter.blockchain.MinterBlockChainApi;
import network.minter.blockchain.models.BCResult;
import network.minter.blockchain.models.BlockInfo;
import network.minter.blockchain.models.Coin;
import network.minter.blockchain.repo.BlockChainBlockRepository;
import network.minter.blockchain.repo.BlockChainCoinRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class get {

    public static void main(String[] args) {
        MinterBlockChainApi.initialize("https://minter-node-1.testnet.minter.network:8841");

        BlockChainCoinRepository repository = MinterBlockChainApi.getInstance().coin();
        Call<BCResult<Coin>> request = repository.getCoinInfo("TESTCOIN");

        request.enqueue(new Callback<BCResult<Coin>>() {
            @Override
            public void onResponse(@NotNull Call<BCResult<Coin>> call, @NotNull Response<BCResult<Coin>> response) {
                BCResult<Coin> body = response.body();
                if(body.isOk()) {
                    // do something with body.result
                } else {
                    Log.d("MinterError", body.error.getMessage());
                }
            }

            @Override
            public void onFailure(@NotNull Call<BCResult<Coin>> call, @NotNull Throwable t) {
                // handle error
            }
        });
    }
}
