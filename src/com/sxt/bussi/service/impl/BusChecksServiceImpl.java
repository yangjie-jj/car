package com.sxt.bussi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.bussi.mapper.BusChecksMapper;
import com.sxt.bussi.service.IBusChecksService;
import com.sxt.common.base.service.impl.BaseServiceImpl;

@Service
public class BusChecksServiceImpl extends BaseServiceImpl implements IBusChecksService {
	
	@Autowired
	private BusChecksMapper busChecksMapper;
	
	public BusChecksServiceImpl(BusChecksMapper busChecksMapper) {
		super(busChecksMapper);
	}

}
