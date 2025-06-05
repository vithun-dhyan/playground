package com.test1234;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Main
{
    public static void main(String[] args)
    {
        SpringApplication.run(Main.class, args);

    }

    private static Boolean isTrue(String splExpression, Map<String, Object> context)
    {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(splExpression);
        EvaluationContext evaluationContext = new StandardEvaluationContext(context);
        context.forEach(evaluationContext::setVariable);
        return expression.getValue(evaluationContext, Boolean.class);

    }

}
