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
            // handle error
        }
    }

    @Override
    public void onFailure(@Nonnull Call<BCResult<CandidateItem>> call, @Nonnull Throwable t) {
        // handle error
    }
});
