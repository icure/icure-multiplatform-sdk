FROM gradle:8.5.0-jdk21 as builder
ARG repoUsername
ARG repoPassword
ARG version
ENV ORG_GRADLE_PROJECT_version=$version
ENV ORG_GRADLE_PROJECT_repoUsername=$repoUsername
ENV ORG_GRADLE_PROJECT_repoPassword=$repoPassword
ENV ORG_GRADLE_PROJECT_mavenRepository=https://maven.taktik.be/content/groups/public
ENV ORG_GRADLE_PROJECT_mavenReleasesRepository=https://maven.taktik.be/content/repositories/releases/
ENV ORG_GRADLE_PROJECT_mavenSnapshotsRepository=https://maven.taktik.be/content/repositories/snapshots/

WORKDIR /build
COPY . ./

RUN gradle -x test :icure-sdk:publishAllPublicationsToTaktikRepository