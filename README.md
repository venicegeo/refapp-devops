# Devops Reference App

## HOWTO

1. Connect github repo to jenkins.
  - `Settings -> Webhooks & Services -> Services -> Add service -> Jenkins (GitHub plugin)`

1. Write scripts for jenkins to run.
  - under /build:
    - setup.sh
    - build.sh
    - build-test.sh
    - artifact.sh
    - artifact-test.sh
    - deploy.sh
    - teardown.sh
    - (all scripts return zero or nonzero, optionally generate a xxx.log file and an xxx.xml for xUnit)

1. Add project to the [Jenkins seed script](https://github.com/venicegeo/jenkins):
    ```
    def projects = [
      [name: 'refapp-devops', jobs: ['setup', 'artifact', 'build-test']]
    ]
    ```
  - *`name` corresponds to the project name as it appears in github; `jobs` is a list of steps for the repository.*
  - [Jenkins](http://jenkins.piazzageo.io) will generate new jobs once the changes to the seed script are committed and pushed.



## Build Steps

### Setup

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

- - -

- `stage.sh`
  - push to cloudfoundry

- `teardown.sh`
  - remove from cloudfoundry


## TODO

- pipelines (and pipeline views)
- connect Jenkins to CF
- containers
- b/g deploys
- diagram
