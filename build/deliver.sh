#!/bin/bash

pushd `dirname $0` > /dev/null
base=$(pwd -P)
popd > /dev/null

# gather some data about the repo
source $base/vars.sh

# do we have this artifact in s3? If not, fail.
[ -f $ARTIFACT ] || { aws s3 ls $S3URL && aws s3 cp $S3URL ./$ARTIFACT || exit 1 }

cf push -p ./$ARTIFACT
