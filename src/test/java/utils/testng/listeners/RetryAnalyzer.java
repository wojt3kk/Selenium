package utils.testng.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.IRetryAnalyzer;

public class RetryAnalyzer implements IRetryAnalyzer{

    private int count = 0;
    private static final int MAX_NUMBEROF_RETRIES = 2;
    private Logger logger = LogManager.getLogger(RetryAnalyzer.class);

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {//Sprawdza czy test zakończył się porażką.
            if (count < MAX_NUMBEROF_RETRIES)  {//Sprawdzamy czy test został powtórzony. Jeśli tak to nie powtarzamy go ponownie
                count++;
                logger.info("Retrying test method {}!", iTestResult.getName());
                return true;
            }
        }
        logger.info("Test method {} will be not retried!", iTestResult.getName());
        return false;
    }
}
