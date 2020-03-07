def config = new ConfigSlurper().parse(readFileFromWorkspace('src/main/resources/example/application/example-properties.groovy'))

job('invoice-matcher-build') {
    label(config.app_name)
}
