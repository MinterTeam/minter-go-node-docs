package network.minter.blockchain.samples.transactions;

import android.util.Log;

import java.util.List;

import javax.annotation.Nonnull;

import network.minter.blockchain.MinterBlockChainApi;
import network.minter.blockchain.models.BCResult;
import network.minter.blockchain.models.HistoryTransaction;
import network.minter.blockchain.repo.BlockChainTransactionRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class get {

    public static void main(String[] args) {
        MinterBlockChainApi.initialize("https://minter-node-1.testnet.minter.network:8841");

        BlockChainTransactionRepository repository = MinterBlockChainApi.getInstance().transactions();


        Call<BCResult<List<HistoryTransaction>>> request = repository.getTransactions(
                new BlockChainTransactionRepository.TQuery()
                        .setFrom("Mx...")
                        .setTo("Mx...")
        );

        request.enqueue(new Callback<BCResult<List<HistoryTransaction>>>() {
            @Override
            public void onResponse(@Nonnull Call<BCResult<List<HistoryTransaction>>> call, @Nonnull Response<BCResult<List<HistoryTransaction>>> response) {
                BCResult<List<HistoryTransaction>> body = response.body();
                if (body.isOk()) {
                    // do something with body.result
                } else {
                    Log.d("MinterError", body.error.getMessage());
                }
            }

            @Override
            public void onFailure(@Nonnull Call<BCResult<List<HistoryTransaction>>> call, @Nonnull Throwable t) {
                // handle error
            }
        });
    }
}
