package network.minter.blockchain.samples.unconfirmed_txs;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import network.minter.blockchain.MinterBlockChainApi;
import network.minter.blockchain.models.BCResult;
import network.minter.blockchain.models.UnconfirmedTransactions;
import network.minter.blockchain.repo.BlockChainTransactionRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class get {

    public static void main(String[] args) {
        MinterBlockChainApi.initialize("https://minter-node-1.testnet.minter.network:8841");

        BlockChainTransactionRepository repository = MinterBlockChainApi.getInstance().transactions();


        Call<BCResult<UnconfirmedTransactions>> request = repository.getUnconfirmedList();

        request.enqueue(new Callback<BCResult<UnconfirmedTransactions>>() {
            @Override
            public void onResponse(@NotNull Call<BCResult<UnconfirmedTransactions>> call, @NotNull Response<BCResult<UnconfirmedTransactions>> response) {
                BCResult<UnconfirmedTransactions> body = response.body();
                if (body.isOk()) {
                    /*
                    for(TransactionSign sign: body.result) {
                        // do smthng with sign
                    }
                    */
                } else {
                    Log.d("MinterError", body.error.getMessage());
                }
            }

            @Override
            public void onFailure(@NotNull Call<BCResult<UnconfirmedTransactions>> call, @NotNull Throwable t) {
                // handle error
            }
        });
    }
}
