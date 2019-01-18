MinterBlockChainApi.initialize("https://minter-node-1.testnet.minter.network:8841");

BlockChainCoinRepository repository = MinterBlockChainApi.getInstance().coin();
Call<BCResult<ExchangeBuyValue>> request = repository.getCoinExchangeCurrencyToBuy(
        "MNT",
        new BigDecimal("10"),
        "TESTCOIN");

request.enqueue(new Callback<BCResult<ExchangeBuyValue>>() {
    @Override
    public void onResponse(@Nonnull Call<BCResult<ExchangeBuyValue>> call, @Nonnull Response<BCResult<ExchangeBuyValue>> response) {
        BCResult<ExchangeBuyValue> body = response.body();
        if (body.isOk()) {
            // do something with body.result
        } else {
            // handle error
        }
    }

    @Override
    public void onFailure(@Nonnull Call<BCResult<ExchangeBuyValue>> call, @Nonnull Throwable t) {
        // handle error
    }
});