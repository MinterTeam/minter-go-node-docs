package network.minter.blockchain.samples.block;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import network.minter.blockchain.MinterBlockChainApi;
import network.minter.blockchain.models.BCResult;
import network.minter.blockchain.models.BlockInfo;
import network.minter.blockchain.repo.BlockChainBlockRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class get {

    public static void main(String[] args) {
        MinterBlockChainApi.initialize("https://minter-node-1.testnet.minter.network:8841");

        BlockChainBlockRepository repository = MinterBlockChainApi.getInstance().block();
        Call<BCResult<BlockInfo>> request = repository.getByHeight(1);

        request.enqueue(new Callback<BCResult<BlockInfo>>() {
            @Override
            public void onResponse(@NotNull Call<BCResult<BlockInfo>> call, @NotNull Response<BCResult<BlockInfo>> response) {
                BCResult<BlockInfo> body = response.body();
                if(body.isOk()) {
                    // do something with body.result
                } else {
                    Log.d("MinterError", body.error.getMessage());
                }
            }

            @Override
            public void onFailure(@NotNull Call<BCResult<BlockInfo>> call, @NotNull Throwable t) {
                // handle error
            }
        });
    }
}
