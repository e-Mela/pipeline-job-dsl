def config = new ConfigSlurper().parse(readFileFromWorkspace('src/main/resources/example/application/example.groovy'))

job('invoice-matcher-build') {
    label(config.app_name)
}
