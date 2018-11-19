import java.util.logging.Logger
import groovy.json.JsonSlurper
import groovy.json.JsonBuilder

Logger log = Logger.getLogger("")
def slurper = new groovy.json.JsonSlurper()

String request=execution.getVariable("designData")
//execution.setVariable("jsonFinalResponse",null)
//def request = '{"actionDeterminants":[{"activity":"Save","component":["vdna"]}],"solution":{"solutionDeterminants":{"solutionType":"NS"},"userId":"ec006e","userRole":["AE","GSE Lead","GSE Support","Read Only","Tech Overlay","Capacity Check","vdna"],"externalKey":6194637,"priceScenarioId":6147228,"designType":"DPP","bundleCode":10001,"erateInd":"N","bulkInd":"N","offers":[{"offerId":4,"site":[{"designDeterminant":{},"siteId":99998422805,"country":"US","state":"GA","designSiteOfferPort":[{"determinants":{"determinantKey":["SITE_MANAGEMENET_OPTION"],"determinantValue":["MANAGED"]},"component":[{"componentCodeId":10,"componentCodeType":"Connection","componentId":12,"designDetails":[{"udfId":20030,"udfAttributeId":[30595]}]}],"vdna":[{"routerId":null,"component":[{"componentCodeId":10,"componentCodeType":"Connection","componentId":12,"designDetails":[{"udfId":20030,"udfAttributeId":[30595]}]},{"componentCodeId":20,"componentCodeType":"Network"},{"componentCodeId":30,"componentCodeType":"Port"},{"componentCodeId":40,"componentCodeType":"Unilink"},{"componentCodeId":50,"componentCodeType":"Cos"},{"componentCodeId":60,"componentCodeType":"Access"},{"componentCodeId":70,"componentCodeType":"CircuitAccess"},{"componentCodeId":80,"componentCodeType":"BroadbandAccess"},{"componentCodeId":90,"componentCodeType":"EthernetAccess"},{"componentCodeId":100,"componentCodeType":"vdna"},{"componentCodeId":110,"componentCodeType":"LogicalChannel"},{"componentCodeId":120,"componentCodeType":"Resiliency"},{"componentCodeId":130,"componentCodeType":"Maro"},{"componentCodeId":140,"componentCodeType":"DiversityGroup"},{"componentCodeId":150,"componentCodeType":"Vpn"},{"componentCodeId":160,"componentCodeType":"Apn"}]}]}]}]}]}}'
def designReq = slurper.parseText(request)

//println "inside save VDNA flow"
//println  "input payload :  ${designReq}"

def siteList1=[]
def siteIdList1=[]
def portIdList=[]
def vdnaBundleCode =null
def vdnaOfferId =null
def offerDataJson = new groovy.json.JsonBuilder()

for(offer in designReq.solution.offers ) {
    vdnaBundleCode =offer.bundleCode
    vdnaOfferId = offer.offerId
    def macdAcType =offer.macdActionType
    for(siteData in offer.site) {
        def vdnaRouter=null
        def siteDataJson = new groovy.json.JsonBuilder()
        for (port in siteData.designSiteOfferPort ) {

            vdnaRouter = port.vdna
            def routerDetails1 =[]

            siteDataJson{
                siteId siteData.siteId
                if(null != macdAcType){
                    macdActionType macdAcType
                }
                portId  port.portId
                portIdList.add(port.portId)
                evpnMigrSiteInd siteData.evpnMigrSiteInd
                typeOfInventory port.typeOfInventory
                routerDetails vdnaRouter
            }
            siteDataJson.toPrettyString()
           // println"site block :: ${siteDataJson}"
            siteList1.add(siteDataJson.content)
            //println "site list block :: ${siteList1}"
        }
        siteIdList1.add(siteData.siteId)

    }

    offerDataJson{
        offerId offer.offerId
        productCd offer.offerId
        siteDetails siteList1
    }
    offerDataJson.toPrettyString()

}

def setvdnaCompInfoRequest = new groovy.json.JsonBuilder()
setvdnaCompInfoRequest{
    userId designReq.solution.userId
    externalKey designReq.solution.externalKey
    solutionType designReq.solution.solutionDeterminants.solutionType
    groupName designReq.solution.erateInd
    siteList siteIdList1
    portList portIdList
    offerList offerDataJson.content
}
def setvdnaCompJson =new groovy.json.JsonBuilder()
def root =setvdnaCompJson{
    setvdnaCompInfoReq setvdnaCompInfoRequest.content
}
println "setvdnaCompJSON is :  ${setvdnaCompJson}"
setvdnaCompJson.toPrettyString()


