def config = new ConfigSlurper().parse(readFileFromWorkspace('src/main/resources/example/application/example-properties.groovy'))

job('example-project-build') {
    label(config.app_name)
    scm {
        git {
            remote {
                name('origin')
                url(config.git.project.url)
                credentials(config.git.github_credential)
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
