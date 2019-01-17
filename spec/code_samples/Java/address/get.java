package network.minter.blockchain.samples.address;

import android.util.Log;

import javax.annotation.Nonnull;

import network.minter.blockchain.MinterBlockChainApi;
import network.minter.blockchain.models.BCResult;
import network.minter.blockchain.models.Balance;
import network.minter.blockchain.repo.BlockChainAccountRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class get {

    public static void main(String[] args) {
        MinterBlockChainApi.initialize("https://minter-node-1.testnet.minter.network:8841");

        BlockChainAccountRepository repository = MinterBlockChainApi.getInstance().account();
        Call<BCResult<Balance>> request = repository.getBalance("Mx618ed05277e7568ee943cd1b8e22ced4cf873f95");

        request.enqueue(new Callback<BCResult<Balance>>() {
            @Override
            public void onResponse(@Nonnull Call<BCResult<Balance>> call, @Nonnull Response<BCResult<Balance>> response) {
                BCResult<Balance> body = response.body();
                if (body.isOk()) {
                    // do something with body.result
                } else {
                    Log.d("MinterError", body.error.getMessage());
                }
            }

            @Override
            public void onFailure(@Nonnull Call<BCResult<Balance>> call, @Nonnull Throwable t) {
                // handle error
            }
        });
    }
}
