MinterBlockChainApi.initialize("https://minter-node-1.testnet.minter.network:8841");

BlockChainCoinRepository repository = MinterBlockChainApi.getInstance().coin();
Call<BCResult<ExchangeSellValue>> request = repository.getCoinExchangeCurrencyToSell(
        "MNT",
        new BigDecimal("10"),
        "TESTCOIN");

request.enqueue(new Callback<BCResult<ExchangeSellValue>>() {
    @Override
    public void onResponse(@Nonnull Call<BCResult<ExchangeSellValue>> call, @Nonnull Response<BCResult<ExchangeSellValue>> response) {
        BCResult<ExchangeSellValue> body = response.body();
        if (body.isOk()) {
            // do something with body.result
        } else {
            // handle error
        }
    }

    @Override
    public void onFailure(@Nonnull Call<BCResult<ExchangeSellValue>> call, @Nonnull Throwable t) {
        // handle error
    }
});
