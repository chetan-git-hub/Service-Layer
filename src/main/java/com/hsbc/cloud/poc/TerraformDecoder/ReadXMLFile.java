package com.hsbc.cloud.poc.TerraformDecoder;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.hsbc.cloud.poc.exception.ResourceNotFoundException;
import com.hsbc.cloud.poc.model.BigQuery;
import com.hsbc.cloud.poc.model.BigTableInstance;
import com.hsbc.cloud.poc.model.BigTableTable;
//import com.hsbc.cloud.poc.model.BootDisk;
import com.hsbc.cloud.poc.model.CloudDns;
import com.hsbc.cloud.poc.model.ComputeEngine;
import com.hsbc.cloud.poc.model.Connections;
import com.hsbc.cloud.poc.model.ContainerRegistry;
import com.hsbc.cloud.poc.model.DBInstance;
import com.hsbc.cloud.poc.model.DataFlow;
import com.hsbc.cloud.poc.model.DataProc;
import com.hsbc.cloud.poc.model.DataStore;
import com.hsbc.cloud.poc.model.Firewall;
import com.hsbc.cloud.poc.model.GKECluster;
import com.hsbc.cloud.poc.model.LoadBalancer;
import com.hsbc.cloud.poc.model.MachineLearning;
import com.hsbc.cloud.poc.model.Mig;
import com.hsbc.cloud.poc.model.NaturalLanguageApi;
import com.hsbc.cloud.poc.model.PersistentDisk;
import com.hsbc.cloud.poc.model.Provider;
import com.hsbc.cloud.poc.model.PubSub;
import com.hsbc.cloud.poc.model.ServiceAccount;
import com.hsbc.cloud.poc.model.SubNetwork;
import com.hsbc.cloud.poc.model.VPCnetwork;
import com.hsbc.cloud.poc.repository.BigQueryRepository;
import com.hsbc.cloud.poc.repository.BigTableInstanceRepository;
import com.hsbc.cloud.poc.repository.BigTableTableRepository;
//import com.hsbc.cloud.poc.repository.BootDiskRepository;
import com.hsbc.cloud.poc.repository.CloudDnsRepository;
import com.hsbc.cloud.poc.repository.ComputeEngineRepository;
import com.hsbc.cloud.poc.repository.ConnectionsRepository;
import com.hsbc.cloud.poc.repository.ContainerRegistryRepository;
import com.hsbc.cloud.poc.repository.DBInstanceRepository;
import com.hsbc.cloud.poc.repository.DataFlowRepository;
import com.hsbc.cloud.poc.repository.DataProcRepository;
import com.hsbc.cloud.poc.repository.DataStoreRepository;
import com.hsbc.cloud.poc.repository.FirewallRepository;
import com.hsbc.cloud.poc.repository.GKEClusterRepository;
import com.hsbc.cloud.poc.repository.LoadBalancerRepository;
import com.hsbc.cloud.poc.repository.MachineLearningRepository;
import com.hsbc.cloud.poc.repository.MigRepository;
import com.hsbc.cloud.poc.repository.NaturalLanguageApiRepository;
import com.hsbc.cloud.poc.repository.PersistentDiskRepository;
import com.hsbc.cloud.poc.repository.ProviderRepository;
import com.hsbc.cloud.poc.repository.PubSubRepository;
import com.hsbc.cloud.poc.repository.ServiceAccountRepository;
import com.hsbc.cloud.poc.repository.SubNetworkRepository;
import com.hsbc.cloud.poc.repository.VPCnetworkRepository;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.StringReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@Component
public class ReadXMLFile {

	// String finalTF;

	@Autowired
	ConnectionsRepository connRepository;

	@Autowired
	VPCnetworkRepository vpcNetworkRepository;
	@Autowired
	ComputeEngineRepository computeEngineRepository;
	/*
	 * @Autowired BootDiskRepository bootDiskRepository;
	 */
	@Autowired
	ServiceAccountRepository serviceAccountRepository;
	@Autowired
	PersistentDiskRepository persistentDiskRepository;
	@Autowired
	FirewallRepository firewallRepository;
	@Autowired
	SubNetworkRepository subNetworkRepository;
	@Autowired
	MigRepository migRepository;
	@Autowired
	CloudDnsRepository cloudDnsRepository;
	@Autowired
	DBInstanceRepository dbInstanceRepository;
	@Autowired
	ProviderRepository providerRepository;
	@Autowired
	BigQueryRepository bigQueryRepository;
	@Autowired
	BigTableInstanceRepository bigTableInstanceRepository;
	@Autowired
	BigTableTableRepository bigTableTableRepository;
	@Autowired
	ContainerRegistryRepository containerRegistryRepository;
	@Autowired
	DataProcRepository dataProcRepository;
	@Autowired
	DataStoreRepository dataStoreRepository;
	@Autowired
	MachineLearningRepository machineLearningRepository;
	@Autowired
	LoadBalancerRepository loadBalancerRepository;
	@Autowired
	PubSubRepository pubSubRepository;
	@Autowired
	DataFlowRepository dataFlowRepository;
	@Autowired
	GKEClusterRepository gkeClusterRepository;
	@Autowired
	NaturalLanguageApiRepository naturalLanguageApiRepository;

	Connections conn = new Connections();
	Provider provider = new Provider();
	VPCnetwork vpcNetwork = new VPCnetwork();
	ComputeEngine computeEngine = new ComputeEngine();
	// BootDisk bootDisk = new BootDisk();
	ServiceAccount serviceAccount = new ServiceAccount();
	PersistentDisk persistentDisk = new PersistentDisk();
	Firewall firewall = new Firewall();
	SubNetwork subNetwork = new SubNetwork();
	Mig mig = new Mig();
	CloudDns cloudDns = new CloudDns();
	DBInstance dbInstance = new DBInstance();
	BigQuery bigQuery = new BigQuery();
	BigTableInstance bigTableInstance = new BigTableInstance();
	BigTableTable bigTableTable = new BigTableTable();
	ContainerRegistry containerRegistry = new ContainerRegistry();
	DataProc dataProc = new DataProc();
	DataStore dataStore = new DataStore();
	MachineLearning machineLearning = new MachineLearning();
	LoadBalancer loadBalancer = new LoadBalancer();
	PubSub pubSub = new PubSub();
	DataFlow dataFlow = new DataFlow();
	GKECluster gkeCluster = new GKECluster();
	NaturalLanguageApi naturalLanguageApi = new NaturalLanguageApi();

	StringBuilder finalTF = new StringBuilder();

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

			//########## Sequencing the components #########
			
			Map<String, Element> map = new HashMap<String, Element>();

			List<Element> list1 = new LinkedList<Element>();
			NodeList nListObject = doc.getElementsByTagName("object");

			Element eElement = null;

			for (int temp = 0; temp < nListObject.getLength(); temp++) {

				Node nNode = nListObject.item(temp);

				eElement = (Element) nNode;

				if (eElement.getAttribute("label").equalsIgnoreCase("Provider"))
					map.put("A-Provider", eElement);

				if (eElement.getAttribute("label").equalsIgnoreCase("VPC"))
					map.put("B-VPC", eElement);

				if (eElement.getAttribute("label").equalsIgnoreCase("SubNetwork"))
					map.put("C-SubNetwork", eElement);
				
				if (eElement.getAttribute("label").equalsIgnoreCase("Persistent Disk"))
					map.put("D-Persistent Disk", eElement);
				
				if (eElement.getAttribute("label").equalsIgnoreCase("Cloud IAM"))
					map.put("E-Cloud IAM", eElement);
				
				if (eElement.getAttribute("label").equalsIgnoreCase("Compute Engine"))
					map.put("F-Compute Engine", eElement);
				
				if (eElement.getAttribute("label").equalsIgnoreCase("Cloud Firewall Rules"))
					map.put("G-Cloud Firewall Rules", eElement);
				
				if (eElement.getAttribute("label").equalsIgnoreCase("Managed Instance Group"))
					map.put("H-Managed Instance Group", eElement);
				
				if (eElement.getAttribute("label").equalsIgnoreCase("Cloud DNS"))
					map.put("I-Cloud DNS", eElement);
				
				if (eElement.getAttribute("label").equalsIgnoreCase("Cloud SQL"))
					map.put("J-Cloud SQL", eElement);
				
				if (eElement.getAttribute("label").equalsIgnoreCase("BigQuery"))
					map.put("K-BigQuery", eElement);
				
				if (eElement.getAttribute("label").equalsIgnoreCase("Cloud Bigtable Instance"))
					map.put("L-Cloud Bigtable Instance", eElement);
				
				if (eElement.getAttribute("label").equalsIgnoreCase("Cloud Bigtable Table"))
					map.put("M-Cloud Bigtable Table", eElement);
				
				if (eElement.getAttribute("label").equalsIgnoreCase("Container Registry"))
					map.put("N-Container Registry", eElement);
				
				if (eElement.getAttribute("label").equalsIgnoreCase("Cloud Dataproc"))
					map.put("O-Cloud Dataproc", eElement);
				
				if (eElement.getAttribute("label").equalsIgnoreCase("Cloud AutoML"))
					map.put("P-Cloud AutoML", eElement);
				
				if (eElement.getAttribute("label").equalsIgnoreCase("Cloud Datastore"))
					map.put("Q-Cloud Datastore", eElement);
				
				if (eElement.getAttribute("label").equalsIgnoreCase("Cloud Load Balancing"))
					map.put("R-Cloud Load Balancing", eElement);
				
				if (eElement.getAttribute("label").equalsIgnoreCase("Cloud Dataflow"))
					map.put("S-Cloud Dataflow", eElement);
				
				if (eElement.getAttribute("label").equalsIgnoreCase("Kubernetes"))
					map.put("T-Kubernetes", eElement);
				
				if (eElement.getAttribute("label").equalsIgnoreCase("Cloud Natural Language API"))
					map.put("U-Cloud Natural Language API", eElement);
				
			}
			TreeMap<String, Element> sorted = new TreeMap<>();

			// Copy all data from hashMap into TreeMap
			sorted.putAll(map);

			// Display the TreeMap which is naturally sorted
			for (Map.Entry<String, Element> entry : sorted.entrySet())
				System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue().getAttribute("label"));

			//########## ################## #########
			
			
			// for (int temp = 0; temp < nListObject.getLength(); temp++) {
			for (Map.Entry<String, Element> entry : sorted.entrySet()) {
				// Node nNode = nListObject.item(temp);
				// Element eElement1 = (Element) nNode;

				String label = entry.getValue().getAttribute("label");
				System.out.println(label);
				String network = "";

				// if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				// 1-Provider
				if (label.equalsIgnoreCase("Provider")) {

					provider.setId(entry.getValue().getAttribute("id"));
					provider.setProvider(entry.getValue().getAttribute("provider"));
					provider.setProject(entry.getValue().getAttribute("project"));
					provider.setRegion(entry.getValue().getAttribute("region"));

					providerRepository.save(provider);

					finalTF.append(provider);
				}
				// 2-VPC Network
				// if VPC is not there then we need to check condition to prepare network value
				if (label.equalsIgnoreCase("VPC")) {

					vpcNetwork.setId(entry.getValue().getAttribute("id"));
					if (isProviderGoogle())
						vpcNetwork.setResource(
								"\"google_compute_network\" \"google_compute_network_" + vpcNetwork.getId() + "\"");

					vpcNetwork.setName(entry.getValue().getAttribute("name"));
					vpcNetwork.setAuto_create_subnetworks(entry.getValue().getAttribute("auto_create_subnetworks"));

					String removedInvertedComma = vpcNetwork.getResource().replaceAll("\"", "");
					network = removedInvertedComma.replaceAll("\\s", ".");

					vpcNetworkRepository.save(vpcNetwork);

					finalTF.append(vpcNetwork);
				}
				// 3-SubNetwork
				if (label.equalsIgnoreCase("SubNetwork")) {
					subNetwork.setId(entry.getValue().getAttribute("id"));
					if (isProviderGoogle())
						subNetwork.setResource("\"google_compute_subnetwork\" \"google_compute_subnetwork_"
								+ subNetwork.getId() + "\"");

					subNetwork.setName(entry.getValue().getAttribute("name"));
					subNetwork.setIp_cidr_range(entry.getValue().getAttribute("ip_cidr_range"));
					subNetwork.setRegion(entry.getValue().getAttribute("region"));
					subNetwork.setNetwork(network + ".id");

					subNetworkRepository.save(subNetwork);

					finalTF.append(subNetwork);
				}
				// 4-Persistent Disk
				String compute_disk = "";
				if (label.equalsIgnoreCase("Persistent Disk")) {
					String image = "";
					persistentDisk.setId(entry.getValue().getAttribute("id"));
					if (isProviderGoogle()) {
						String id = persistentDisk.getId();
						persistentDisk.setData("\"google_compute_image\" \"google_compute_image_" + id + "\"");
						persistentDisk.setResource("\"google_compute_disk\" \"google_compute_disk_" + id + "\"");

						image = "data.google_compute_image.google_compute_image_" + id + ".self_link";
						compute_disk = "google_compute_disk.google_compute_disk_" + id + ".self_link";
					}
					persistentDisk.setFamily(entry.getValue().getAttribute("family"));
					persistentDisk.setProject(entry.getValue().getAttribute("project"));
					persistentDisk.setName(entry.getValue().getAttribute("name"));
					persistentDisk.setSize(entry.getValue().getAttribute("size"));
					persistentDisk.setType(entry.getValue().getAttribute("type"));
					persistentDisk.setImage(image);
					persistentDisk.setZone(entry.getValue().getAttribute("zone"));

					persistentDiskRepository.save(persistentDisk);

					finalTF.append(persistentDisk);

				}
				// 5-Service Account (Cloud IAM)
				String email = "";
				if (label.equalsIgnoreCase("Cloud IAM")) {

					serviceAccount.setId(entry.getValue().getAttribute("id"));
					String id = serviceAccount.getId();
					if (isProviderGoogle()) {
						serviceAccount.setResource("\"google_service_account\" \"google_service_account_" + id + "\"");
						email = "google_service_account.google_service_account_" + id + ".email";
					}
					serviceAccount.setAccount_id(entry.getValue().getAttribute("account_id"));
					serviceAccount.setDisplay_name(entry.getValue().getAttribute("display_name"));

					serviceAccountRepository.save(serviceAccount);

					finalTF.append(serviceAccount);
				}
				// 6-Compute Engine
				if (label.equalsIgnoreCase("Compute Engine")) {

					computeEngine.setId(entry.getValue().getAttribute("id"));
					if (isProviderGoogle())
						computeEngine.setResource("\"google_compute_instance\" \"google_compute_instance_"
								+ computeEngine.getId() + "\"");

					computeEngine.setName(entry.getValue().getAttribute("name"));
					computeEngine.setZone(entry.getValue().getAttribute("zone"));
					computeEngine.setMachine_type(entry.getValue().getAttribute("machine_type"));
					computeEngine.setAllow_stopping_for_update(entry.getValue().getAttribute("allow_update"));
					computeEngine.setTags(entry.getValue().getAttribute("tags"));

					// eElement1.getAttribute("Subnetwork");
					computeEngine.setSource(compute_disk);
					/*
					 * bootDisk.setId(eElement1.getAttribute("id"));
					 * bootDisk.setImage(eElement1.getAttribute("source"));
					 * bootDisk.setComputeVM(computeEngine); computeEngine.setBootDisk(bootDisk);
					 */
					computeEngine.setNetwork(network);
					computeEngine.setEmail(email);
					computeEngine.setScopes(entry.getValue().getAttribute("scopes"));

					computeEngineRepository.save(computeEngine);

					finalTF.append(computeEngine);
				}

				// 7-Firewall
				if (label.equalsIgnoreCase("Cloud Firewall Rules")) {
					firewall.setId(entry.getValue().getAttribute("id"));
					if (isProviderGoogle())
						firewall.setResource(
								"\"google_compute_firewall\" \"google_compute_firewall_" + firewall.getId() + "\"");
					// firewall.setResource("\"google_compute_firewall\" \"default\"");

					firewall.setName(entry.getValue().getAttribute("name"));
					firewall.setNetwork(network + ".name");
					firewall.setSource_tags(entry.getValue().getAttribute("source_tag"));
					firewall.setProtocol(entry.getValue().getAttribute("protocol"));
					firewall.setPorts(entry.getValue().getAttribute("ports"));

					firewallRepository.save(firewall);

					finalTF.append(firewall);
				}
				// 8-Managed Instance Group
				if (label.equalsIgnoreCase("Managed Instance Group")) {
					mig.setId(entry.getValue().getAttribute("id"));
					if (isProviderGoogle())
						mig.setResource("\"google_compute_instance_template\" \"google_compute_instance_template_"
								+ mig.getId() + "\"");
					// mig.setResource("\"google_compute_instance_template\" \"template\"");

					mig.setName_prefix(entry.getValue().getAttribute("name_prefix"));
					mig.setMachine_type(entry.getValue().getAttribute("machine_type"));
					mig.setTags(entry.getValue().getAttribute("tags"));
					mig.setAutomatic_restart(entry.getValue().getAttribute("automatic_restart"));
					mig.setOn_host_maintenance(entry.getValue().getAttribute("on_host_maintenance"));

					String removedInvertedComma = subNetwork.getResource().replaceAll("\"", "");
					String subnetwork = removedInvertedComma.replaceAll("\\s", ".");
					mig.setSubnetwork(subnetwork + ".self_link");

					String removedInvertedComma1 = persistentDisk.getResource().replaceAll("\"", "");
					String source = removedInvertedComma1.replaceAll("\\s", ".");
					mig.setSource(source + ".name");

					mig.setAuto_delete(entry.getValue().getAttribute("auto_delete"));
					mig.setBoot(entry.getValue().getAttribute("boot"));

					mig.setEmail(email);
					mig.setScopes(entry.getValue().getAttribute("scopes"));

					mig.setCreate_before_destroy(entry.getValue().getAttribute("create_before_destroy"));

					migRepository.save(mig);

					finalTF.append(mig);
				}
				// 9-Cloud DNS
				if (label.equalsIgnoreCase("Cloud DNS")) {
					String managed_zone = "";
					cloudDns.setId(entry.getValue().getAttribute("id"));
					if (isProviderGoogle()) {
						cloudDns.setResource("\"google_dns_managed_zone\" \"example\"");
						cloudDns.setManagedResource("\"google_dns_record_set\" \"example\"");

						managed_zone = "google_dns_managed_zone.example";
					}
					cloudDns.setName(entry.getValue().getAttribute("name"));
					cloudDns.setDns_name(entry.getValue().getAttribute("dns_name"));

					cloudDns.setManaged_zone(managed_zone + ".name");
					cloudDns.setManaged_name("www.${" + managed_zone + ".dns_name}");

					cloudDns.setType(entry.getValue().getAttribute("type"));
					cloudDns.setRrdatas(entry.getValue().getAttribute("rrdatas"));
					cloudDns.setTtl(entry.getValue().getAttribute("ttl"));

					cloudDnsRepository.save(cloudDns);

					finalTF.append(cloudDns);
				}
				// 10-DB Instance Cloud SQL
				if (label.equalsIgnoreCase("Cloud SQL")) {

					dbInstance.setId(entry.getValue().getAttribute("id"));
					if (isProviderGoogle()) {
						dbInstance.setResource("\"google_sql_database_instance\" \"db_instance\"");
						dbInstance.setResourceSqlDatabase("\"google_sql_database\" \"database\"");
						dbInstance.setResourceRandomPassword("\"google_sql_database\" \"password\"");
						dbInstance.setResourceSqlUser("\"google_sql_user\" \"users\"");
					}
					dbInstance.setDbinstancename(entry.getValue().getAttribute("db_instance_name"));
					dbInstance.setDbversion(entry.getValue().getAttribute("database_version"));
					dbInstance.setTier(entry.getValue().getAttribute("tier"));
					dbInstance.setDeletion_protection(entry.getValue().getAttribute("deletion_protection"));
					dbInstance.setSqldbname(entry.getValue().getAttribute("sql_db_name"));

					String removedInvertedComma = dbInstance.getResource().replaceAll("\"", "");
					String instance = removedInvertedComma.replaceAll("\\s", ".");
					dbInstance.setSqldbinstance(instance + ".name");

					dbInstance.setPasswordlength(entry.getValue().getAttribute("random_password_length"));
					dbInstance.setPasswordoverridespecial(entry.getValue().getAttribute("password_override_special"));
					dbInstance.setPasswordspecial(entry.getValue().getAttribute("password_special"));

					dbInstance.setSqlusername(entry.getValue().getAttribute("sql_user_name"));
					dbInstance.setSqluserhost(entry.getValue().getAttribute("host"));
					dbInstance.setSqluserinstance(instance + ".name");

					String removedInvertedComma1 = dbInstance.getResourceRandomPassword().replaceAll("\"", "");
					String password = removedInvertedComma1.replaceAll("\\s", ".");
					dbInstance.setSqluserpassword(password + ".result");

					dbInstanceRepository.save(dbInstance);

					finalTF.append(dbInstance);
				}
				// 11-bigquery dataset
				if (label.equalsIgnoreCase("BigQuery")) {
					bigQuery.setId(entry.getValue().getAttribute("id"));
					if (isProviderGoogle())
						bigQuery.setResource(
								"\"google_bigquery_dataset\" \"google_bigquery_dataset_" + bigQuery.getId() + "\"");

					bigQuery.setDataset_id(entry.getValue().getAttribute("dataset_id"));
					bigQuery.setLocation(entry.getValue().getAttribute("location"));
					bigQuery.setDefault_table_expiration_ms(
							entry.getValue().getAttribute("default_table_expiration_ms"));
					bigQuery.setEnv(entry.getValue().getAttribute("env"));

					bigQueryRepository.save(bigQuery);

					finalTF.append(bigQuery);
				}
				// 12-bigtable instance
				if (label.equalsIgnoreCase("Cloud Bigtable Instance")) {
					bigTableInstance.setId(entry.getValue().getAttribute("id"));
					if (isProviderGoogle())
						bigTableInstance.setResource("\"google_bigtable_instance\" \"google_bigtable_instance_"
								+ bigTableInstance.getId() + "\"");

					bigTableInstance.setName(entry.getValue().getAttribute("name"));
					bigTableInstance.setCluster_id(entry.getValue().getAttribute("cluster_id"));
					bigTableInstance.setNum_nodes(entry.getValue().getAttribute("num_nodes"));
					bigTableInstance.setStorage_type(entry.getValue().getAttribute("storage_type"));
					bigTableInstance.setPrevent_destroy(entry.getValue().getAttribute("prevent_destroy"));

					bigTableInstanceRepository.save(bigTableInstance);

					finalTF.append(bigTableInstance);
				}

				// 13-bigtable table
				if (label.equalsIgnoreCase("Cloud Bigtable Table")) {
					String instance_name = "";
					bigTableTable.setId(entry.getValue().getAttribute("id"));
					if (isProviderGoogle()) {
						String id = bigTableTable.getId();
						bigTableTable.setResource("\"google_bigtable_table\" \"google_bigtable_table_" + id + "\"");
						instance_name = "google_bigtable_table.google_bigtable_table_" + id + ".name";
					}
					bigTableTable.setName(entry.getValue().getAttribute("name"));

					bigTableTable.setInstance_name(instance_name);
					bigTableTable.setSplit_keys(entry.getValue().getAttribute("split_keys"));
					bigTableTable.setPrevent_destroy(entry.getValue().getAttribute("prevent_destroy"));

					bigTableTableRepository.save(bigTableTable);

					finalTF.append(bigTableTable);
				}

				// 14-Container Registry
				if (label.equalsIgnoreCase("Container Registry")) {

					containerRegistry.setId(entry.getValue().getAttribute("id"));
					if (isProviderGoogle())
						containerRegistry.setResource("\"google_container_registry\" \"google_container_registry_"
								+ containerRegistry.getId() + "\"");

					containerRegistry.setLocation(entry.getValue().getAttribute("location"));

					containerRegistryRepository.save(containerRegistry);

					finalTF.append(containerRegistry);
				}

				// 15-DataProc
				if (label.equalsIgnoreCase("Cloud Dataproc")) {

					dataProc.setId(entry.getValue().getAttribute("id"));
					if (isProviderGoogle())
						dataProc.setResource(
								"\"google_dataproc_cluster\" \"google_dataproc_cluster_" + dataProc.getId() + "\"");

					dataProc.setName(entry.getValue().getAttribute("name"));
					dataProc.setRegion(entry.getValue().getAttribute("region"));

					dataProcRepository.save(dataProc);

					finalTF.append(dataProc);
				}

				// 16-DataStore
				if (label.equalsIgnoreCase("Cloud Datastore")) {

					dataStore.setId(entry.getValue().getAttribute("id"));
					if (isProviderGoogle())
						dataStore.setResource(
								"\"google_datastore_index\" \"google_datastore_index_" + dataStore.getId() + "\"");

					dataStore.setKind(entry.getValue().getAttribute("kind"));
					dataStore.setName(entry.getValue().getAttribute("name"));
					dataStore.setDirection(entry.getValue().getAttribute("direction"));

					dataStoreRepository.save(dataStore);

					finalTF.append(dataStore);
				}

				// 17-Machine Learning
				if (label.equalsIgnoreCase("Cloud AutoML")) {

					machineLearning.setId(entry.getValue().getAttribute("id"));
					if (isProviderGoogle())
						machineLearning.setResource("\"google_ml_engine_model\" \"google_ml_engine_model_"
								+ machineLearning.getId() + "\"");

					machineLearning.setName(entry.getValue().getAttribute("name"));
					machineLearning.setDescription(entry.getValue().getAttribute("description"));
					machineLearning.setFunction(entry.getValue().getAttribute("function"));
					machineLearning
							.setOnline_prediction_logging(entry.getValue().getAttribute("online_prediction_logging"));
					machineLearning.setOnline_prediction_console_logging(
							entry.getValue().getAttribute("online_prediction_console_logging"));

					machineLearningRepository.save(machineLearning);

					finalTF.append(machineLearning);
				}
				// 18-Load Balancer
				if (label.equalsIgnoreCase("Cloud Load Balancing")) {

					loadBalancer.setId(entry.getValue().getAttribute("id"));
					String backend_service = "";
					String health_checks = "";
					if (isProviderGoogle()) {
						String id = loadBalancer.getId();
						loadBalancer.setResourceForwardingRule(
								"\"google_compute_forwarding_rule\" \"google_compute_forwarding_rule_" + id + "\"");
						loadBalancer.setResourceBackendService(
								"\"google_compute_region_backend_service\" \"google_compute_region_backend_service_"
										+ id + "\"");
						loadBalancer.setResourceHealthCheck(
								"\"google_compute_health_check\" \"google_compute_health_check_" + id + "\"");
						backend_service = "google_compute_region_backend_service.google_compute_region_backend_service_"
								+ id + ".id";
						health_checks = "google_compute_health_check.google_compute_health_check_" + id + ".id";
					}

					loadBalancer.setProvider(entry.getValue().getAttribute("provider"));
					loadBalancer.setHealthCheckName(entry.getValue().getAttribute("heath_check_name"));
					loadBalancer.setCheck_interval_sec(entry.getValue().getAttribute("check_interval_sec"));
					loadBalancer.setTimeout_sec(entry.getValue().getAttribute("timeout_sec"));
					loadBalancer.setPort(entry.getValue().getAttribute("port"));

					loadBalancer.setBackendServiceName(entry.getValue().getAttribute("backend_service_name"));
					loadBalancer.setHealth_checks(health_checks);

					loadBalancer.setForwardingRuleName(entry.getValue().getAttribute("forwardingrRule_name"));
					loadBalancer.setLoad_balancing_scheme(entry.getValue().getAttribute("load_balancing_scheme"));
					loadBalancer.setAll_ports(entry.getValue().getAttribute("all_ports"));
					loadBalancer.setBackend_service(backend_service);

					loadBalancerRepository.save(loadBalancer);

					finalTF.append(loadBalancer);

				}
				// 19-pub-sub
				String topic = "";
				String subscription = "";
				String dead_letter_topic = "";
				if (label.equalsIgnoreCase("Cloud Pub/Sub")) {

					pubSub.setId(entry.getValue().getAttribute("id"));

					if (isProviderGoogle()) {
						String id = pubSub.getId();
						pubSub.setResourcePubSubTopic("\"google_pubsub_topic\" \"google_pubsub_topic_" + id + "\"");
						pubSub.setResourcePubSubTopicDeadLetter(
								"\"google_pubsub_topic\" \"google_pubsub_topic_dead_letter_" + id + "\"");
						pubSub.setResourcePubSubSubscription(
								"\"google_pubsub_subscription\" \"google_pubsub_subscription_" + id + "\"");
						topic = "google_pubsub_topic.google_pubsub_topic_" + id + ".name";
						dead_letter_topic = "google_pubsub_topic.google_pubsub_topic_dead_letter_" + id + ".id";
						subscription = "google_pubsub_subscription.google_pubsub_subscription_" + id + ".id";
					}

					pubSub.setPubSubTopicName(entry.getValue().getAttribute("topic_name"));
					pubSub.setPubSubTopicDeadLetterName(entry.getValue().getAttribute("dead_letter_topic_name"));
					pubSub.setPubSubSubscriptionName(entry.getValue().getAttribute("subscription_name"));
					pubSub.setTopic(topic);
					pubSub.setDead_letter_topic(dead_letter_topic);
					pubSub.setMax_delivery_attempts(entry.getValue().getAttribute("max_delivery_attempts"));

					pubSubRepository.save(pubSub);

					finalTF.append(pubSub);
				}

				// 20-data flow job
				if (label.equalsIgnoreCase("Cloud Dataflow")) {

					dataFlow.setId(entry.getValue().getAttribute("id"));

					if (isProviderGoogle()) {
						dataFlow.setResource(
								"\"google_dataflow_job\" \"google_dataflow_job_" + dataFlow.getId() + "\"");
					}

					dataFlow.setName(entry.getValue().getAttribute("name"));
					dataFlow.setTemp_gcs_location(entry.getValue().getAttribute("temp_gcs_location"));
					dataFlow.setTemplate_gcs_path(entry.getValue().getAttribute("template_gcs_path"));
					dataFlow.setNetwork(entry.getValue().getAttribute("network"));
					dataFlow.setInputSubscription(subscription);
					dataFlow.setOutputTopic(topic);

					dataFlowRepository.save(dataFlow);

					finalTF.append(dataFlow);
				}
				// 21-GKE-Cluster
				if (label.equalsIgnoreCase("Kubernetes")) {

					gkeCluster.setId(entry.getValue().getAttribute("id"));
					String cluster = "";
					if (isProviderGoogle()) {
						String id = gkeCluster.getId();
						gkeCluster.setResourceCluster(
								"\"google_container_cluster\" \"google_container_cluster_" + id + "\"");
						gkeCluster.setResourceNodePool(
								"\"google_container_node_pool\" \"google_container_node_pool_" + id + "\"");
						cluster = "google_container_cluster.google_container_cluster_" + id + ".name";
					}

					gkeCluster.setCluster_name(entry.getValue().getAttribute("cluster_name"));
					gkeCluster.setCluster_location(entry.getValue().getAttribute("cluster_location"));
					gkeCluster.setRemove_default_node_pool(entry.getValue().getAttribute("remove_default_node_pool"));
					gkeCluster.setInitial_node_count(entry.getValue().getAttribute("initial_node_count"));

					gkeCluster.setNode_pool_name(entry.getValue().getAttribute("node_pool_name"));
					gkeCluster.setCluster(cluster);
					gkeCluster.setNode_count(entry.getValue().getAttribute("node_count"));
					gkeCluster.setPreemptible(entry.getValue().getAttribute("preemptible"));
					gkeCluster.setMachine_type(entry.getValue().getAttribute("machine_type"));
					gkeCluster.setService_account(email);
					gkeCluster.setOauth_scopes(entry.getValue().getAttribute("oauth_scopes"));

					gkeClusterRepository.save(gkeCluster);

					finalTF.append(gkeCluster);
				}

				// 22-Natural Language API
				if (label.equalsIgnoreCase("Cloud Natural Language API")) {

					naturalLanguageApi.setId(entry.getValue().getAttribute("id"));

					if (isProviderGoogle())
						naturalLanguageApi.setResource("\"google_dialogflow_agent\" \"google_dialogflow_agent_"
								+ entry.getValue().getAttribute("id") + "\"");

					naturalLanguageApi.setDisplay_name(entry.getValue().getAttribute("display_name"));
					naturalLanguageApi.setDefault_language_code(entry.getValue().getAttribute("default_language_code"));
					naturalLanguageApi
							.setSupported_language_codes(entry.getValue().getAttribute("supported_language_codes"));
					naturalLanguageApi.setTime_zone(entry.getValue().getAttribute("time_zone"));
					naturalLanguageApi.setDescription(entry.getValue().getAttribute("description"));
					naturalLanguageApi.setEnable_logging(entry.getValue().getAttribute("enable_logging"));
					naturalLanguageApi.setMatch_mode(entry.getValue().getAttribute("match_mode"));
					naturalLanguageApi
							.setClassification_threshold(entry.getValue().getAttribute("classification_threshold"));
					naturalLanguageApi.setApi_version(entry.getValue().getAttribute("api_version"));
					naturalLanguageApi.setTier(entry.getValue().getAttribute("tier"));

					naturalLanguageApiRepository.save(naturalLanguageApi);

					finalTF.append(naturalLanguageApi);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return finalTF.toString();
	}

	private boolean isProviderGoogle() {

		if (provider.getProvider().equalsIgnoreCase("Google"))
			return true;

		return false;

	}
}