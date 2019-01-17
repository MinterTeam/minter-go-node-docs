package network.minter.blockchain.samples.candidate;

import android.util.Log;

import javax.annotation.Nonnull;

import network.minter.blockchain.MinterBlockChainApi;
import network.minter.blockchain.models.BCResult;
import network.minter.blockchain.models.CandidateItem;
import network.minter.blockchain.repo.BlockChainCandidateRepository;
import network.minter.core.crypto.MinterPublicKey;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class get {

    public static void main(String[] args) {
        MinterBlockChainApi.initialize("https://minter-node-1.testnet.minter.network:8841");

        BlockChainCandidateRepository repository = MinterBlockChainApi.getInstance().candidate();

        // Get candidate by Public Key
        Call<BCResult<CandidateItem>> requestByPubKey = repository.getCandidate(new MinterPublicKey("Mpb52951425d2517504f767215ca77a9be3e0cd788fd72443da9b174fc686a37f0"));

        requestByPubKey.enqueue(new Callback<BCResult<CandidateItem>>() {
            @Override
            public void onResponse(@Nonnull Call<BCResult<CandidateItem>> call, @Nonnull Response<BCResult<CandidateItem>> response) {
                BCResult<CandidateItem> body = response.body();
                if (body.isOk()) {
                    // do something with body.result
                } else {
                    Log.d("MinterError", body.error.getMessage());
                }
            }

            @Override
            public void onFailure(@Nonnull Call<BCResult<CandidateItem>> call, @Nonnull Throwable t) {
                // handle error
            }
        });

        // Get candidate by Public Key and block height
        Call<BCResult<CandidateItem>> requestByPubKeyAndHeight = repository.getCandidate(
                new MinterPublicKey("Mpb52951425d2517504f767215ca77a9be3e0cd788fd72443da9b174fc686a37f0"),
                100
        );

        requestByPubKeyAndHeight.enqueue(new Callback<BCResult<CandidateItem>>() {
            @Override
            public void onResponse(@Nonnull Call<BCResult<CandidateItem>> call, @Nonnull Response<BCResult<CandidateItem>> response) {
                BCResult<CandidateItem> body = response.body();
                if (body.isOk()) {
                    // do something with body.result
                } else {
                    Log.d("MinterError", body.error.getMessage());
                }
            }

            @Override
            public void onFailure(@Nonnull Call<BCResult<CandidateItem>> call, @Nonnull Throwable t) {
                // handle error
            }
        });
    }
}
