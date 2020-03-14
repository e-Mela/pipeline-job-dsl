def config = new ConfigSlurper().parse(readFileFromWorkspace('src/main/resources/example/application/example-properties.groovy'))

job('example-project-build') {
    label(config.app_name)
    scm {
        git {
            remote {
                github('e-Mela/sample-project', 'https')
                credentials('github_credential')
            }
            branch(config.git.project.branch)
        }
    }
    wrappers {
        timestamps()
    }
    steps {
        environmentVariables {
            propertiesFile('gradle.properties')
        }
        gradle('clean build')
    }
    triggers {
        githubPush()
    }

    publishers {

    }
}
