package eci.arsw.covidanalyzer.service;

import java.util.UUID;

import eci.arsw.covidanalyzer.model.Result;
import eci.arsw.covidanalyzer.model.ResultType;

public class CovidAggregate implements ICovidAggregateService {
	List<Result>respuesta
	public CovidAggregate() {
		
		Result resultado1 = new Result("Alejandro","Toro",1,"3118227475",ResultType.TRUE_POSITIVE);
		Result resultado2 = new Result("Andres","Perez",2,"3102840123",ResultType.TRUE_NEGATIVE);
		Result resultado3 = new Result("Manuel","Alvarez",3,"3201904284",ResultType.TRUE_POSITIVE);
		Result resultado4 = new Result("Andrea","Medina",4,"3501892847",ResultType.TRUE_POSITIVE);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean aggregateResult(Result result, ResultType type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getResult(ResultType type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void upsertPersonWithMultipleTests(UUID id, ResultType type) {
		// TODO Auto-generated method stub
		
	}
}