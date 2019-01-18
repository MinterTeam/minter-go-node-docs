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
            // handle error
        }
    }

    @Override
    public void onFailure(@Nonnull Call<BCResult<List<NetworkStatus.Validator>>> call, @Nonnull Throwable t) {
        // handle error
    }
});
