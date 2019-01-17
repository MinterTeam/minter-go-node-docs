package network.minter.blockchain.samples.transaction;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import network.minter.blockchain.MinterBlockChainApi;
import network.minter.blockchain.models.BCResult;
import network.minter.blockchain.models.HistoryTransaction;
import network.minter.blockchain.models.TransactionCommissionValue;
import network.minter.blockchain.repo.BlockChainTransactionRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class get {

    public static void main(String[] args) {
        MinterBlockChainApi.initialize("https://minter-node-1.testnet.minter.network:8841");

        BlockChainTransactionRepository repository = MinterBlockChainApi.getInstance().transactions();


        Call<BCResult<HistoryTransaction>> request = repository.getTransaction("");

        request.enqueue(new Callback<BCResult<HistoryTransaction>>() {
            @Override
            public void onResponse(@NotNull Call<BCResult<HistoryTransaction>> call, @NotNull Response<BCResult<HistoryTransaction>> response) {
                BCResult<HistoryTransaction> body = response.body();
                if(body.isOk()) {
                    // do something with body.result
                } else {
                    Log.d("MinterError", body.error.getMessage());
                }
            }

            @Override
            public void onFailure(@NotNull Call<BCResult<HistoryTransaction>> call, @NotNull Throwable t) {
                // handle error
            }
        });
    }
}
