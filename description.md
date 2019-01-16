# Introduction

Minter is a blockchain network that lets people, projects, and companies issue and manage their own coins and trade them at a fair market price with absolute and instant liquidity.

# Install Minter

There are several ways you can install Minter Blockchain Testnet node on your machine.

## Using binary

1. **Download Minter**

   Get [latest binary build](https://github.com/MinterTeam/minter-go-node/releases) suitable for your architecture and unpack it to desired folder.

2. **Run Minter**

   ```bash
   ./minter
   ```

	Then open http://localhost:3000/ in local browser to see node's GUI.

## From Source

You'll need `golang` installed https://golang.org/doc/install and the required
[environment variables set](https://github.com/tendermint/tendermint/wiki/Setting-GOPATH)

1. **Clone Minter source code to your machine**

	```bash
	mkdir -p $GOPATH/src/github.com/MinterTeam
	cd $GOPATH/src/github.com/MinterTeam
	git clone https://github.com/MinterTeam/minter-go-node.git
	cd minter-go-node
	```

2. **Get Tools & Dependencies**

	```bash
	make get_tools
	make get_vendor_deps
	```

3. **Compile**

	```bash
	make install
	```

	to put the binary in `$GOPATH/bin` or use:

	```bash
	make build
	```

	to put the binary in `./build`.

	The latest `minter version` is now installed.

4. **Run Minter**

	```bash
	minter
	```

	Then open `http://localhost:3000/` in local browser to see node's GUI.

# Blockchain Specification

**Tendermint**

Minter Blockchain utilizes `Tendermint Consensus Engine`.

Tendermint is software for securely and consistently replicating an application on many machines.
By securely, we mean that Tendermint works even if up to 1/3 of machines fail in arbitrary ways.
By consistently, we mean that every non-faulty machine sees the same transaction log and computes the same state.
Secure and consistent replication is a fundamental problem in distributed systems; it plays a critical role in the
fault tolerance of a broad range of applications, from currencies, to elections, to infrastructure orchestration,
and beyond.

Tendermint is designed to be easy-to-use, simple-to-understand, highly performant, and useful for a wide variety of
distributed applications.

You can read more about Tendermint Consensus in [official documentation](https://tendermint.com/docs/)

**Consensus**

In Minter we implemented Delegated Proof of Stake (DPOS) Consensus Protocol.

DPOS is the fastest, most efficient, most decentralized, and most flexible consensus model available. DPOS leverages the power of stakeholder approval voting to resolve consensus issues in a fair and democratic way.

**Block speed**

Minter Blockchain is configured to produce `1 block per 5 sec`. Actual block speed may vary depends on validators count, their computational power, internet speed, etc.

**Block size**

We limit block size to `10 000 transactions`. Block size in terms of bytes is not limited.

# Coins

Minter Blockchain is multi-coin system.

Base coin in testnet is `MNT`.\
Base coin in mainnet is `BIP`.

Smallest part of *each* coin is called `pip`.\
1 pip = 1^-18 of any coin. In Blockchain and API we only operating with pips.

> **Note:** Each coin has its **own** pip. You should treat pip like atomic part of a coin, not as currency:\
> 1 MNT = 10^18 pip (MNT's pip)\
> 1 ABC = 10^18 pip (ABC's pip)\
> 1 MNT != 1 ABC

## Coin Issuance

Every user of Minter can issue own coin. Each coin is backed by base coin in some proportion.
Issue own coin is as simple as filling a form with given fields:

- **Coin name** - Name of a coin. Arbitrary string up to 64 letters length.
- **Coin symbol** - Symbol of a coin. Must be unique, alphabetic, uppercase, 3 to 10 letters length.
- **Initial supply** - Amount of coins to issue. Issued coins will be available to sender account.
- **Initial reserve** - Initial reserve in base coin.
- **Constant Reserve Ratio (CRR)** - uint, should be from 10 to 100.

After coin issued you can send is as ordinary coin using standard wallets.

## Issuance Fees

To issue a coin Coiner should pay fee. Fee is depends on length of Coin Symbol.

3 letters – 1 000 000 bips + standard transaction fee\
4 letters – 100 000 bips + standard transaction fee\
5 letters – 10 000 bips + standard transaction fee\
6 letters – 1000 bips + standard transaction fee\
7 letters – 100 bips + standard transaction fee\
8 letters – 10 bips + standard transaction fee\
9-10 letters - just standard transaction fee\

## Coin Exchange

Each coin in system can be instantly exchanged to another coin. This is possible because each coin has "reserve" in base
coin.

Here are some formulas we are using for coin conversion:

**CalculatePurchaseReturn**\
Given a coin supply (s), reserve balance (r), CRR (c) and a deposit amount (d), calculates the return for a given conversion (in the base coin):

```golang
return s * ((1 + d / r) ^ c - 1);
```	


**CalculateSaleReturn**\
Given a coin supply (s), reserve balance (r), CRR (c) and a sell amount (a), calculates the return for a given conversion

```golang
return r * (1 - (1 - a / s) ^ (1 / c));
```
