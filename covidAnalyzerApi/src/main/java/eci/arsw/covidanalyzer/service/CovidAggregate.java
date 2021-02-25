package eci.arsw.covidanalyzer.service;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Service;
import eci.arsw.covidanalyzer.model.Result;
import eci.arsw.covidanalyzer.model.ResultType;
@Service
public class CovidAggregate implements ICovidAggregateService {
	List<Result> respuesta;
	public CovidAggregate() {
		respuesta=new CopyOnWriteArrayList<>();
		Result resultado1 = new Result("Alejandro","Toro",1,"3118227475",ResultType.TRUE_POSITIVE);
		Result resultado2 = new Result("Andres","Perez",2,"3102840123",ResultType.TRUE_NEGATIVE);
		Result resultado3 = new Result("Manuel","Alvarez",3,"3201904284",ResultType.TRUE_POSITIVE);
		Result resultado4 = new Result("Andrea","Medina",4,"3501892847",ResultType.TRUE_POSITIVE);
		respuesta.add(resultado1);
		respuesta.add(resultado2);
		respuesta.add(resultado3);
		respuesta.add(resultado4);
	}
	@Override
	public boolean aggregateResult(Result result, ResultType type) throws ErrorExcepcion {
		for (Result it:respuesta)
		{
			if(it.getId()==result.getId())
			{
				throw new ErrorExcepcion("Esta cuenta ya ha sido creada.");
			}
		}
		respuesta.add(result);
		return true;
	}
	@Override
	public List<Result> getResult(ResultType type) {
		List<Result> restfin=new CopyOnWriteArrayList<>();
		for (Result it:respuesta)
		{
			if(it.getTipo().equals(type))
			{
				restfin.add(it);
			}
		}
		return restfin;
	}
	@Override
	public void upsertPersonWithMultipleTests(int id, ResultType type) {
		for (Result it:respuesta)
		{
			System.out.println(it.getId()==id);
		}
	}
}