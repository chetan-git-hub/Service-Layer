package com.hsbc.cloud.poc.TerraformDecoder;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.hsbc.cloud.poc.model.BootDisk;
import com.hsbc.cloud.poc.model.ComputeVM;
import com.hsbc.cloud.poc.model.Connections;
import com.hsbc.cloud.poc.model.ServiceAccount;
import com.hsbc.cloud.poc.repository.BootDiskRepository;
import com.hsbc.cloud.poc.repository.ComputeVmRepository;
import com.hsbc.cloud.poc.repository.ConnectionsRepository;
import com.hsbc.cloud.poc.repository.ServiceAccountRepository;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.StringReader;

@Component
public class ReadXMLFile {
	
	String finalTF;
	
	@Autowired
	ConnectionsRepository connRepository;
	
	@Autowired
	ComputeVmRepository computeVmRepository;
	@Autowired
	BootDiskRepository bootDiskRepository;
	@Autowired
	ServiceAccountRepository serviceAccountRepository;

	Connections conn = new Connections();
	ComputeVM computeVM = new ComputeVM();
	BootDisk bootDisk = new BootDisk();
	ServiceAccount serviceAccount = new ServiceAccount();

	public String XMLParser(String xmlData) {

		try {

			// File fXmlFile = new File("/media/chetan/CHETAN-DATA/decoder/xmlfile.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			// Document doc = dBuilder.parse(fXmlFile);

			Document doc = dBuilder.parse(new InputSource(new StringReader(xmlData)));

			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
			
			/*
			 * NodeList nListDiagram = doc.getElementsByTagName("diagram");
			 * 
			 * Node nNode = nListDiagram.item(0);
			 * 
			 * System.out.println("\nCurrent Element :" + nNode.getNodeName()); Element
			 * eElement = (Element) nNode; if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			 * 
			 * conn.setId(eElement.getAttribute("id"));
			 * conn.setSource(eElement.getAttribute("source"));
			 * conn.setTarget(eElement.getAttribute("target"));
			 * 
			 * connRepository.save(conn); }
			 */
			 
		
			
			
			NodeList nListArrows = doc.getElementsByTagName("mxCell");


			for (int temp = 0; temp < nListArrows.getLength(); temp++) {

				Node nNode = nListArrows.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				Element eElement = (Element) nNode;
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					
					if (eElement.hasAttribute("edge")) {
						
						conn.setId(eElement.getAttribute("id"));
						conn.setSource(eElement.getAttribute("source"));
						conn.setTarget(eElement.getAttribute("target"));
						
						connRepository.save(conn);
					}

				}
			}
			
			
			NodeList nListObject = doc.getElementsByTagName("object");

			
			for (int temp = 0; temp < nListObject.getLength(); temp++) {

				Node nNode = nListObject.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				Element eElement = (Element) nNode;
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					
					if (eElement.getAttribute("label").equals("vm")) {
						
						computeVM.setId(eElement.getAttribute("id"));
						computeVM.setResource(eElement.getAttribute("Resource"));
						computeVM.setName(eElement.getAttribute("Name"));
						computeVM.setZone(eElement.getAttribute("Zone"));
						computeVM.setMachine_type(eElement.getAttribute("Machine_Type"));
						computeVM.setAllow_stopping_for_update(eElement.getAttribute("Allow_Update"));
						computeVM.setTags(eElement.getAttribute("Tags"));
						
						bootDisk.setId(eElement.getAttribute("id"));
						bootDisk.setImage(eElement.getAttribute("Source"));
						bootDisk.setComputeVM(computeVM);
						computeVM.setBootDisk(bootDisk);
						
						computeVmRepository.save(computeVM);
					}

					if (eElement.getAttribute("label").equals("sa")) {
						
						serviceAccount.setId(eElement.getAttribute("id"));
						serviceAccount.setResource(eElement.getAttribute("Resource"));
						serviceAccount.setAccount_id(eElement.getAttribute("Account_Id"));
						serviceAccount.setDisplay_name(eElement.getAttribute("Display_Name"));
						
						serviceAccountRepository.save(serviceAccount);
					}

				}
			}
			// computeVmRepo.save(computeVM);
			
			
			
		finalTF = "resource \"google_compute_instance\" "+computeVM.getResource()+" {\n"
			+ "  name                        = "+computeVM.getName()+"\n"
			+ "  zone                        = "+computeVM.getZone()+"\n"
			+ "  machine_type                = "+computeVM.getMachine_type()+"\n"
			+ "  allow_stopping_for_update   = "+computeVM.getAllow_stopping_for_update()+"\n"
			+ "  tags                        = "+computeVM.getTags()+"\n"
			+ "\n"
			+ "  boot_disk {\n"
			+ "    initialize_params {\n"
			+ "      source = google_compute_disk."+computeVM.getBootDisk().getImage()+".self_link\n"
			+ "    }\n"
			+ "  }\n"
			+ "\n"
			+ "  network_interface {\n"
			+ "    subnetwork = google_compute_subnetwork.cloud_ui_poc_subnetwork.self_link\n"
			+ "  }\n"
			+ "\n"
			+ "  service_account {\n"
			+ "    email  = google_service_account."+serviceAccount.getResource()+".email\n"
			+ "    scopes = [\"cloud-platform\"]\n"
			+ "  }\n"
			+ "}";
			
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return finalTF;
	}
	
		
	
	/*
	 * public String finalTF(ComputeVM computeVM, ServiceAccount serviceAccount) {
	 * 
	 * if(computeVM.getId())
	 * 
	 * return finalTF; }
	 */

}