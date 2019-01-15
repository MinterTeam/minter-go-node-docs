# Minter Go Node API OpenAPI Specification
[![Build Status](https://travis-ci.com/MinterTeam/minter-go-node-api-docs.svg?branch=master)](https://travis-ci.com/MinterTeam/minter-go-node-api-docs)

## Links

- [Reference Documentation (ReDoc)](https://minterteam.github.io/minter-go-node-api-docs/)
- OpenAPI Raw Files: [JSON](https://minterteam.github.io/minter-go-node-api-docs/openapi.json) [YAML](https://minterteam.github.io/minter-go-node-api-docs/openapi.yaml)

**Warning:** All above links are updated only after Travis CI finishes deployment

## Working on specification
### Install

1. Install [Node JS](https://nodejs.org/)
2. Clone repo and run `npm install` in the repo root

### Usage

#### `npm start`
Starts the development server.

#### `npm run build`
Bundles the spec and prepares web_deploy folder with static assets.

#### `npm test`
Validates the spec.

#### `npm run gh-pages`
Deploys docs to GitHub Pages. You don't need to run it manually if you have Travis CI configured.
