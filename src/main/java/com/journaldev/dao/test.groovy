package com.journaldev.dao

import java.util.logging.Logger
import groovy.json.JsonSlurper
import groovy.json.JsonBuilder

println "Hello world"

def slurper = new groovy.json.JsonSlurper()

def request = '{"actionDeterminants":[{"activity":"Save","component":["vdna"]}],"solution":{"solutionDeterminants":{"solutionType":"NS"},"userId":"ec006e","userRole":["AE","GSE Lead","GSE Support","Read Only","Tech Overlay","Capacity Check","vdna"],"externalKey":6194637,"priceScenarioId":6147228,"designType":"DPP","bundleCode":10001,"erateInd":"N","bulkInd":"N","offers":[{"offerId":4,"site":[{"designDeterminant":{},"siteId":99998422805,"country":"US","state":"GA","designSiteOfferPort":[{"determinants":{"determinantKey":["SITE_MANAGEMENET_OPTION"],"determinantValue":["MANAGED"]},"component":[{"componentCodeId":10,"componentCodeType":"Connection","componentId":12,"designDetails":[{"udfId":20030,"udfAttributeId":[30595]}]}],"vdna":[{"routerId":null,"component":[{"componentCodeId":10,"componentCodeType":"Connection","componentId":12,"designDetails":[{"udfId":20030,"udfAttributeId":[30595]}]},{"componentCodeId":20,"componentCodeType":"Network"},{"componentCodeId":30,"componentCodeType":"Port"},{"componentCodeId":40,"componentCodeType":"Unilink"},{"componentCodeId":50,"componentCodeType":"Cos"},{"componentCodeId":60,"componentCodeType":"Access"},{"componentCodeId":70,"componentCodeType":"CircuitAccess"},{"componentCodeId":80,"componentCodeType":"BroadbandAccess"},{"componentCodeId":90,"componentCodeType":"EthernetAccess"},{"componentCodeId":100,"componentCodeType":"vdna"},{"componentCodeId":110,"componentCodeType":"LogicalChannel"},{"componentCodeId":120,"componentCodeType":"Resiliency"},{"componentCodeId":130,"componentCodeType":"Maro"},{"componentCodeId":140,"componentCodeType":"DiversityGroup"},{"componentCodeId":150,"componentCodeType":"Vpn"},{"componentCodeId":160,"componentCodeType":"Apn"}]}]}]}]}]}}'

//String request=execution.getVariable("designData")
println request

def designReq = slurper.parseText(request)



//execution.setVariable("jsonFinalResponse",null)
println "inside save VDNA flow"
println  "input payload :  ${designReq}"

def siteList1=[]
def vdnaBundleCode =null
def vdnaOfferId =null
def userId = null
def externalKey = null
def solutionType = null
def groupName =null


// Start



//END
for(offer in designReq.solution.offers ) {
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
                evpnMigrSiteInd siteData.evpnMigrSiteInd
                typeOfInventory port.typeOfInventory
                routerDetails vdnaRouter
            }
            siteDataJson.toPrettyString()
            println "site block :: ${siteDataJson}"
            siteList1.add(siteDataJson.content)
            println "site list block :: ${siteList1}"
        }

    }

}

def setvdnaCompInfoRequest = new groovy.json.JsonBuilder()
setvdnaCompInfoRequest{
    bundleCode vdnaBundleCode
    offerId vdnaOfferId
    erateInd designReq.solution.erateInd
    solutionType designReq.solution.solutionDeterminants.solutionType
    externalKey designReq.solution.externalKey
    evpnMigrSolInd designReq.solution.evpnMigrSolInd
    userId designReq.solution.userId
    siteList siteList1
}
def setvdnaCompJson =new groovy.json.JsonBuilder()
def root =setvdnaCompJson{
    setvdnaCompInfoReq setvdnaCompInfoRequest.content
}
println "setvdnaCompJSON is :  ${setvdnaCompJson}"
setvdnaCompJson.toPrettyString()




