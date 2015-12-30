# Devops Reference App

## HOWTO

1. Connect github repo to jenkins.
  - `Settings -> Webhooks & Services -> Services -> Add service -> Jenkins (GitHub plugin)`

1. Write scripts for jenkins to run in the scripts directory.
  - follow the convention of `<job-name>.sh`
  - all scripts must return zero or nonzero
  - use the job keyword `cf-deliver` to automate a CloudFoundry deploy.

1. Add project to the [Jenkins seed script](https://github.com/venicegeo/jenkins):
    ```
    def projects = [
      [name: 'refapp-devops', jobs: ['setup', 'artifact', 'cf-deliver']]
    ]
    ```
  - *`name` corresponds to the project name as it appears in github; `jobs` is a list of steps for the repository.*
  - the collection of steps will form a build pipeline that will process serially.
  - [Jenkins](http://jenkins.piazzageo.io) will generate new jobs once the changes to the seed script are committed and pushed.



## Sample Build Steps

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

- `cf-deliver.sh`
  - push to cloudfoundry

- `teardown.sh`
  - remove from cloudfoundry


## TODO

- containers?
- iterate on project definiton (jenkins.yml file in repo)
- b/g deploys
- diagram
