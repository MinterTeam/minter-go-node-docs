package network.minter.blockchain.samples.events;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;

import network.minter.blockchain.MinterBlockChainApi;
import network.minter.blockchain.models.BCResult;
import network.minter.blockchain.models.EventList;
import network.minter.blockchain.models.TransactionSendResult;
import network.minter.blockchain.models.operational.OperationInvalidDataException;
import network.minter.blockchain.models.operational.Transaction;
import network.minter.blockchain.models.operational.TransactionSign;
import network.minter.blockchain.repo.BlockChainAccountRepository;
import network.minter.blockchain.repo.BlockChainEventRepository;
import network.minter.core.crypto.PrivateKey;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class get {

    public static void main(String[] args) throws OperationInvalidDataException {
        MinterBlockChainApi.initialize("https://minter-node-1.testnet.minter.network:8841");

        BlockChainEventRepository repository = MinterBlockChainApi.getInstance().event();

        long blockHeight = 1;
        Call<BCResult<EventList>> request = repository.getEvents(blockHeight);

        request.enqueue(new Callback<BCResult<EventList>>() {
            @Override
            public void onResponse(@NotNull Call<BCResult<EventList>> call, @NotNull Response<BCResult<EventList>> response) {
                BCResult<EventList> body = response.body();
                if(body.isOk()) {
                    // EventList.RewardEvent event = body.result.events.get(0).getValue();
                    // EventList.SlashEvent event = body.result.events.get(1).getValue();
                    // do something with body.result
                } else {
                    Log.d("MinterError", body.error.getMessage());
                }
            }

            @Override
            public void onFailure(@NotNull Call<BCResult<EventList>> call, @NotNull Throwable t) {
                // handle error
            }
        });
    }
}
