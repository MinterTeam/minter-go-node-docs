package network.minter.blockchain.samples.send_transaction;

import android.util.Log;

import java.math.BigInteger;

import javax.annotation.Nonnull;

import network.minter.blockchain.MinterBlockChainApi;
import network.minter.blockchain.models.BCResult;
import network.minter.blockchain.models.TransactionSendResult;
import network.minter.blockchain.models.operational.OperationInvalidDataException;
import network.minter.blockchain.models.operational.Transaction;
import network.minter.blockchain.models.operational.TransactionSign;
import network.minter.blockchain.repo.BlockChainAccountRepository;
import network.minter.core.crypto.PrivateKey;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class get {

    public static void main(String[] args) throws OperationInvalidDataException {
        MinterBlockChainApi.initialize("https://minter-node-1.testnet.minter.network:8841");

        BlockChainAccountRepository repository = MinterBlockChainApi.getInstance().account();

        // build transaction with builder,
        // see https://github.com/MinterTeam/minter-android-blockchain#2-creating-and-signing-transactions for more details
        Transaction tx = new Transaction.Builder(new BigInteger("1"))
                .sendCoin()
                .build();

        PrivateKey pk = new PrivateKey("...");
        TransactionSign sign = tx.signSingle(pk);

        Call<BCResult<TransactionSendResult>> request = repository.sendTransaction(sign);

        request.enqueue(new Callback<BCResult<TransactionSendResult>>() {
            @Override
            public void onResponse(@Nonnull Call<BCResult<TransactionSendResult>> call, @Nonnull Response<BCResult<TransactionSendResult>> response) {
                BCResult<TransactionSendResult> body = response.body();
                if (body.isOk()) {
                    // do something with body.result
                } else {
                    Log.d("MinterError", body.error.getMessage());
                }
            }

            @Override
            public void onFailure(@Nonnull Call<BCResult<TransactionSendResult>> call, @Nonnull Throwable t) {
                // handle error
            }
        });
    }
}
