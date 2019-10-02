package openws.papillon.ru.controller;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import ru.papillon.openws.opserver.AddImageToCardRequest;
import ru.papillon.openws.opserver.AddImageToCardResponse;
import ru.papillon.openws.opserver.CancelCardRequest;
import ru.papillon.openws.opserver.CancelCardResponse;
import ru.papillon.openws.opserver.CancelFindRequest;
import ru.papillon.openws.opserver.CancelFindResponse;
import ru.papillon.openws.opserver.Candidate;
import ru.papillon.openws.opserver.CheckStatusRequest;
import ru.papillon.openws.opserver.CheckStatusResponse;
import ru.papillon.openws.opserver.CreateCardRequest;
import ru.papillon.openws.opserver.CreateCardResponse;
import ru.papillon.openws.opserver.FindFingersRequest;
import ru.papillon.openws.opserver.FindFingersResponse;
import ru.papillon.openws.opserver.FindFingersUnspecRequest;
import ru.papillon.openws.opserver.FindFingersUnspecResponse;
import ru.papillon.openws.opserver.FindRequestRequest;
import ru.papillon.openws.opserver.FindRequestResponse;
import ru.papillon.openws.opserver.FindResponse;
import ru.papillon.openws.opserver.GetCandidateRequest;
import ru.papillon.openws.opserver.GetCandidateResponse;
import ru.papillon.openws.opserver.GetImagesRequest;
import ru.papillon.openws.opserver.GetImagesResponse;
import ru.papillon.openws.opserver.GetInfoRequest;
import ru.papillon.openws.opserver.GetInfoResponse;
import ru.papillon.openws.opserver.ObjectFactory;
import ru.papillon.openws.opserver.SaveCardRequest;
import ru.papillon.openws.opserver.SaveCardResponse;
import ru.papillon.openws.opserver.StatusResponce;
import ru.papillon.openws.opserver.Tag;
/**
 * @author Akramul
 * @since 02-10-2019
 * @version 1.0.0
 */
@Endpoint
public class FingerprintController {

	private static final String SERVER_NAMESPACE = "http://openws.papillon.ru/OPServer";

	@PayloadRoot(namespace = SERVER_NAMESPACE, localPart = "findFingersRequest")
	@ResponsePayload
	public JAXBElement<FindFingersResponse> findFingerPrint(@RequestPayload JAXBElement<FindFingersRequest> request) {
		FindFingersResponse response = new FindFingersResponse();

		FindResponse fr = new FindResponse();

		fr.setErrorCode(0);
		fr.setToken("Token generated 4");
		fr.setErrorMess(null);
		fr.setId("1");

		response.setReturn(fr);
		
		return new ObjectFactory().createFindFingersResponse(response);
	}
	
	@PayloadRoot(namespace = SERVER_NAMESPACE, localPart = "getInfoRequest")
	@ResponsePayload
	public JAXBElement<GetInfoResponse> getInfo(@RequestPayload JAXBElement<GetInfoRequest> request) {
		GetInfoResponse response = new GetInfoResponse();
		response.setReturn("Fingerprint SOAP API BY ATI Mobile Apps Team");
		
		return new ObjectFactory().createGetInfoResponse(response);
	}
	
	@PayloadRoot(namespace = SERVER_NAMESPACE, localPart = "findRequestRequest")
	@ResponsePayload
	public JAXBElement<FindRequestResponse> findRequest(@RequestPayload JAXBElement<FindRequestRequest> request) {
		FindRequestResponse response = new FindRequestResponse();
		
		FindResponse fr = new FindResponse();

		fr.setErrorCode(0);
		fr.setToken("Token generated 1");
		fr.setErrorMess(null);
		fr.setId("1");
		
		response.setReturn(fr);
		return new ObjectFactory().createFindRequestResponse(response);
	}
	
	@PayloadRoot(namespace = SERVER_NAMESPACE, localPart = "checkStatusRequest")
	@ResponsePayload
	public JAXBElement<CheckStatusResponse> checkStatusRequest(@RequestPayload JAXBElement<CheckStatusRequest> request) {
		CheckStatusResponse response = new CheckStatusResponse();
		
		StatusResponce fr = new StatusResponce();

		fr.setErrorCode(0);
		fr.setComplete(1);
		fr.setErrorMess(null);
		fr.setStatus(1);
		
		response.setReturn(fr);
		return new ObjectFactory().createCheckStatusResponse(response);
	}
	
	@PayloadRoot(namespace = SERVER_NAMESPACE, localPart = "findFingersUnspecRequest")
	@ResponsePayload
	public JAXBElement<FindFingersUnspecResponse> findFingersUnspec(@RequestPayload JAXBElement<FindFingersUnspecRequest> request) {
		FindFingersUnspecResponse response = new FindFingersUnspecResponse();
		
		FindResponse fr = new FindResponse();

		fr.setErrorCode(0);
		fr.setToken("Token generated");
		fr.setErrorMess(null);
		fr.setId("1");
		
		response.setReturn(fr);
		return new ObjectFactory().createFindFingersUnspecResponse(response);
	}
	
	@PayloadRoot(namespace = SERVER_NAMESPACE, localPart = "getImagesRequest")
	@ResponsePayload
	public JAXBElement<GetImagesResponse> getImagesRequest(@RequestPayload JAXBElement<GetImagesRequest> request) {
		GetImagesResponse response = new GetImagesResponse();
		
		Candidate c = new Candidate();
		List<Tag> imageTags = new ArrayList<>();
		
		Tag tag = new Tag();
		tag.setId("1");
		tag.setCaption("Person Image");
		tag.setValue("https://avatars1.githubusercontent.com/u/34574050?s=460&v=4");
		
		Tag tag1 = new Tag();
		tag1.setId("2");
		tag1.setCaption("Person Image2");
		tag1.setValue("https://avatars1.githubusercontent.com/u/34574050?s=460&v=4");
		
		imageTags.add(tag);
		imageTags.add(tag1);
		
		c.setErrorCode(1);
		c.setErrorMess("No error found");
		c.setImageTags(imageTags);
		c.setTextTags(imageTags);
		
		response.setReturn(c);
		return new ObjectFactory().createGetImagesResponse(response);
	}
	
	@PayloadRoot(namespace = SERVER_NAMESPACE, localPart = "getCandidateRequest")
	@ResponsePayload
	public JAXBElement<GetCandidateResponse> getCandidateRequest(@RequestPayload JAXBElement<GetCandidateRequest> request) {
		GetCandidateResponse response = new GetCandidateResponse();
		
		Candidate c = new Candidate();
		c.setErrorCode(1);
		c.setErrorMess("No error found");
		
		response.setReturn(c);
		return new ObjectFactory().createGetCandidateResponse(response);
	}
	
	@PayloadRoot(namespace = SERVER_NAMESPACE, localPart = "createCardRequest")
	@ResponsePayload
	public JAXBElement<CreateCardResponse> createCardRequest(@RequestPayload JAXBElement<CreateCardRequest> request) {
		CreateCardResponse response = new CreateCardResponse();
		
		FindResponse fr = new FindResponse();

		fr.setErrorCode(0);
		fr.setToken("Token generated");
		fr.setErrorMess(null);
		fr.setId("1");
		
		response.setReturn(fr);
		return new ObjectFactory().createCreateCardResponse(response);
	}
	
	@PayloadRoot(namespace = SERVER_NAMESPACE, localPart = "cancelCardRequest")
	@ResponsePayload
	public JAXBElement<CancelCardResponse> cancelCardRequest(@RequestPayload JAXBElement<CancelCardRequest> request) {
		CancelCardResponse response = new CancelCardResponse();
		
		StatusResponce fr = new StatusResponce();
		fr.setComplete(1);
		fr.setErrorCode(0);
		fr.setErrorMess("");
		fr.setStatus(1);
		
		response.setReturn(fr);
		return new ObjectFactory().createCancelCardResponse(response);
	}
	
	@PayloadRoot(namespace = SERVER_NAMESPACE, localPart = "saveCardRequest")
	@ResponsePayload
	public JAXBElement<SaveCardResponse> saveCardRequest(@RequestPayload JAXBElement<SaveCardRequest> request) {
		SaveCardResponse response = new SaveCardResponse();
		
		StatusResponce fr = new StatusResponce();
		fr.setComplete(1);
		fr.setErrorCode(0);
		fr.setErrorMess("");
		fr.setStatus(1);
		
		response.setReturn(fr);
		return new ObjectFactory().createSaveCardResponse(response);
	}
	
	@PayloadRoot(namespace = SERVER_NAMESPACE, localPart = "cancelFindRequest")
	@ResponsePayload
	public JAXBElement<CancelFindResponse> cancelFindRequest(@RequestPayload JAXBElement<CancelFindRequest> request) {
		CancelFindResponse response = new CancelFindResponse();
		
		StatusResponce fr = new StatusResponce();
		fr.setComplete(1);
		fr.setErrorCode(0);
		fr.setErrorMess("");
		fr.setStatus(1);
		
		response.setReturn(fr);
		return new ObjectFactory().createCancelFindResponse(response);
	}
	
	@PayloadRoot(namespace = SERVER_NAMESPACE, localPart = "addImageToCardRequest")
	@ResponsePayload
	public JAXBElement<AddImageToCardResponse> addImageToCardRequest(@RequestPayload JAXBElement<AddImageToCardRequest> request) {
		AddImageToCardResponse response = new AddImageToCardResponse();
		
		StatusResponce fr = new StatusResponce();
		fr.setComplete(1);
		fr.setErrorCode(0);
		fr.setErrorMess("");
		fr.setStatus(1);
		
		response.setReturn(fr);
		return new ObjectFactory().createAddImageToCardResponse(response);
	}

}
