package com.irandoo.app.interf.util;


import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

@Component
public class BsQuartzJobFactory extends AdaptableJobFactory{
	    @Autowired
	    private AutowireCapableBeanFactory capableBeanFactory;
	    
	    @Override
	    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
	        
	        Object jobInstance=super.createJobInstance(bundle);
	        capableBeanFactory.autowireBean(jobInstance);
	        return super.createJobInstance(bundle);
	    }
}
