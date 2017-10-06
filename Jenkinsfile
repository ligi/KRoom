node {

 stage 'checkout'
  checkout scm

 stage 'lint'
  try {
   sh "./gradlew lint"
  } catch(err) {
   currentBuild.result = FAILURE
  } finally {
   androidLint canComputeNew: false, defaultEncoding: '', healthy: '', pattern: '', unHealthy: ''
  }

 stage 'test'
  try {
   sh "./gradlew test"
  } catch(err) {
   currentBuild.result = FAILURE
  } finally {
   step([$class: 'JUnitResultArchiver', testResults: 'lib/build/test-results/*/*.xml'])
   publishHTML(target:[allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'lib/build/reports/tests/', reportFiles: "*/index.html", reportName: 'UnitTest'])
  }
  
 stage 'assemble'
  sh "./gradlew assemble"
     
}