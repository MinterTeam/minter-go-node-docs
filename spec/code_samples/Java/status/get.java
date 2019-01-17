package network.minter.blockchain.samples.status;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import network.minter.blockchain.MinterBlockChainApi;
import network.minter.blockchain.models.BCResult;
import network.minter.blockchain.models.NetworkStatus;
import network.minter.blockchain.models.TransactionCommissionValue;
import network.minter.blockchain.repo.BlockChainStatusRepository;
import network.minter.blockchain.repo.BlockChainTransactionRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class get {

    public static void main(String[] args) {
        MinterBlockChainApi.initialize("https://minter-node-1.testnet.minter.network:8841");

        BlockChainStatusRepository repository = MinterBlockChainApi.getInstance().status();

        Call<BCResult<NetworkStatus>> request = repository.getNetworkStatus();


        request.enqueue(new Callback<BCResult<NetworkStatus>>() {
            @Override
            public void onResponse(@NotNull Call<BCResult<NetworkStatus>> call, @NotNull Response<BCResult<NetworkStatus>> response) {
                BCResult<NetworkStatus> body = response.body();
                if(body.isOk()) {
                    // do something with body.result
                } else {
                    Log.d("MinterError", body.error.getMessage());
                }
            }

            @Override
            public void onFailure(@NotNull Call<BCResult<NetworkStatus>> call, @NotNull Throwable t) {
                // handle error
            }
        });
    }
}
