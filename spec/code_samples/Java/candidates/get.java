MinterBlockChainApi.initialize("https://minter-node-1.testnet.minter.network:8841");

BlockChainCandidateRepository repository = MinterBlockChainApi.getInstance().candidate();

// Get candidate by public key
Call<BCResult<List<CandidateStatus>>> request = repository.getBlockCandidates(100);

request.enqueue(new Callback<BCResult<List<CandidateStatus>>>() {
    @Override
    public void onResponse(@Nonnull Call<BCResult<List<CandidateStatus>>> call, @Nonnull Response<BCResult<List<CandidateStatus>>> response) {
        BCResult<List<CandidateStatus>> body = response.body();
        if (body.isOk()) {
            // do something with body.result
        } else {
            // handle error
        }
    }

    @Override
    public void onFailure(@Nonnull Call<BCResult<List<CandidateStatus>>> call, @Nonnull Throwable t) {
        // handle error
    }
});
