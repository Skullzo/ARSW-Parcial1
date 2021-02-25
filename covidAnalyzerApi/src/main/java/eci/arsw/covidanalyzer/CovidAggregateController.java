package eci.arsw.covidanalyzer;
import eci.arsw.covidanalyzer.model.Result;
import eci.arsw.covidanalyzer.model.ResultType;
import eci.arsw.covidanalyzer.service.CovidAggregate;
import eci.arsw.covidanalyzer.service.ErrorExcepcion;
import eci.arsw.covidanalyzer.service.ICovidAggregateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CovidAggregateController {
	@Autowired
    CovidAggregate service;
    ICovidAggregateService covidAggregateService;
    @RequestMapping(value = "/covid/result/true-positive", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> addTruePositiveResult(@RequestBody Result result) {
        try {
        	ResultType resta=ResultType.TRUE_POSITIVE;
        	service.aggregateResult(result, resta);
		} catch (ErrorExcepcion e) {
			e.printStackTrace();
		}
        return null;
    }
    @RequestMapping(value = "/covid/result/true-negative", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> addTrueNegativeResult(@RequestBody Result result) {
        try {
        	ResultType resta=ResultType.TRUE_NEGATIVE;
        	service.aggregateResult(result, resta);
		} catch (ErrorExcepcion e) {
			e.printStackTrace();
		}
        return null;
    }
    @RequestMapping(value = "/covid/result/false-negative", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> addFalseNegativeResult(@RequestBody Result result) {
        try {
        	ResultType resta=ResultType.FALSE_POSITIVE;
        	service.aggregateResult(result, resta);
		} catch (ErrorExcepcion e) {
			e.printStackTrace();
		}
        return null;
    }
    @RequestMapping(value = "/covid/result/false-positive", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> addFalsePositiveResult(@RequestBody Result result) {
        try {
        	ResultType resta=ResultType.FALSE_POSITIVE;
        	service.aggregateResult(result, resta);
		} catch (ErrorExcepcion e) {
			e.printStackTrace();
		}
        return null;
    }
    @RequestMapping(value = "/covid/result/true-positive", method = RequestMethod.GET)
    public ResponseEntity<?> getTruePositiveResult() throws ErrorExcepcion {
    	ResultType result=ResultType.TRUE_POSITIVE;
        return new ResponseEntity<>(service.getResult(result), HttpStatus.ACCEPTED);
    }
    @RequestMapping(value = "/covid/result/true-negative", method = RequestMethod.GET)
    public ResponseEntity<?> getTrueNegativeResult() throws ErrorExcepcion {
    	ResultType result=ResultType.TRUE_NEGATIVE;
        return new ResponseEntity<>(service.getResult(result), HttpStatus.ACCEPTED);

    }
    @RequestMapping(value = "/covid/result/persona/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> savePersonaWithMultipleTests(@PathVariable String id, @RequestBody Result result) {
        service.upsertPersonWithMultipleTests(result);
        return null;
    } 
}