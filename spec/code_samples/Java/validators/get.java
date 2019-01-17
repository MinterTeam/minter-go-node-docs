package network.minter.blockchain.samples.validators;

import android.util.Log;

import java.util.List;

import javax.annotation.Nonnull;

import network.minter.blockchain.MinterBlockChainApi;
import network.minter.blockchain.models.BCResult;
import network.minter.blockchain.models.NetworkStatus;
import network.minter.blockchain.repo.BlockChainStatusRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class get {

    public static void main(String[] args) {
        MinterBlockChainApi.initialize("https://minter-node-1.testnet.minter.network:8841");

        BlockChainStatusRepository repository = MinterBlockChainApi.getInstance().status();

        Call<BCResult<List<NetworkStatus.Validator>>> request = repository.getValidators();

        request.enqueue(new Callback<BCResult<List<NetworkStatus.Validator>>>() {
            @Override
            public void onResponse(@Nonnull Call<BCResult<List<NetworkStatus.Validator>>> call, @Nonnull Response<BCResult<List<NetworkStatus.Validator>>> response) {
                BCResult<List<NetworkStatus.Validator>> body = response.body();
                if (body.isOk()) {
                    // do something with body.result
                } else {
                    Log.d("MinterError", body.error.getMessage());
                }
            }

            @Override
            public void onFailure(@Nonnull Call<BCResult<List<NetworkStatus.Validator>>> call, @Nonnull Throwable t) {
                // handle error
            }
        });
    }
}
