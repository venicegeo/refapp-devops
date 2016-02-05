# Devops Reference App

A sample build pipeline using the [VeniceGEO devops infrastructure](https://docs.google.com/drawings/d/1ulbWSQQL5CzveHTtUxiN0eZsDWPrH3QzbggqoVo4MZE/edit?usp=sharing). Ignore the Clojure `src` and `test` files: they just create a simple "hello world" web server. The intresting bits:
  - `./scripts/*`: outline each step in the devlops pipeline.
  - `./manifest.yml`: controls the CloudFoundry deployment.

## How to add a pipeline to your project!

1. Connect github repo to jenkins.
  - `Settings -> Webhooks & Services -> Services -> Add service -> Jenkins (GitHub plugin)`
  - Webhook URL: `http://jenkins.piazzageo.io/github-webhook/`

1. Write scripts for jenkins to run in the `./scripts` directory.
  - follow the convention of `<job-name>.sh`
  - all scripts must return zero or nonzero
  - use the job-name keyword `cf-deliver` to automate a CloudFoundry deploy.
  - (make sure the scripts are executeable)

1. Create a `manifest.yml` file to control CloudFoundry deploys.

1. Add project to the [Jenkins ProjectMap script](https://github.com/venicegeo/jenkins):
    ```
    static projects = [
      [name: 'refapp-devops', jobs: ['setup', 'artifact', 'cf-deliver']]
    ]
    ```
  - *`name` corresponds to the project name as it appears in github; `jobs` is a list of steps for the repository.*
  - the collection of steps will form a build pipeline that will process serially.
  - [Jenkins](http://jenkins.piazzageo.io) will generate new jobs once the changes to the seed script are committed and pushed.


## Suggested Build Steps

- `setup.sh`
  - dependency resolution
  - static code analysis
- `build.sh`
  - compilation
- `build-test.sh`
  - unit tests
- `artifact.sh`
  - create runtime artifact (container?)
  - upload artifact to S3.
- `artifact-test.sh`
  - testing of the artifact
- `cf-deliver.sh`
  - push to cloudfoundry
- `teardown.sh`
  - remove from cloudfoundry


## TODO

- major documentation effort
- full explanation of services (+ a tl;dr)
- solidify naming conventions
- create roadmap
  - cf users?
  - tunneling
  - containers?
  - iterate on project definiton (jenkins.yml file in repo)
