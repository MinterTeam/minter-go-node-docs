MinterBlockChainApi.initialize("https://minter-node-1.testnet.minter.network:8841");

BlockChainCoinRepository repository = MinterBlockChainApi.getInstance().coin();
Call<BCResult<Coin>> request = repository.getCoinInfo("TESTCOIN");

request.enqueue(new Callback<BCResult<Coin>>() {
    @Override
    public void onResponse(@Nonnull Call<BCResult<Coin>> call, @Nonnull Response<BCResult<Coin>> response) {
        BCResult<Coin> body = response.body();
        if (body.isOk()) {
            // do something with body.result
        } else {
            // handle error
        }
    }

    @Override
    public void onFailure(@Nonnull Call<BCResult<Coin>> call, @Nonnull Throwable t) {
        // handle error
    }
});
 