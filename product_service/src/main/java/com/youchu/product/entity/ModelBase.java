package com.youchu.product.entity;

import java.util.Date;

public class ModelBase {
    private String id;

    private String bizid;

    private String checkflag;

    private String emplcode;

    private String orgcode;

    private String orglevel;

    private String checktype;

    private String custname;

    private String loanamout;

    private String checkmodel;

    private String lineamout;

    private String yearlyinspection;

    private String linebalance;

    private String loanbalance;

    private String revalofcoll;

    private Date collestimatedate;

    private String collestimatevalue;

    private String collestimatemsg;

    private String securitykind;

    private String othersecuritykindmsg;

    private String repaykind;

    private Date repaydate;

    private String repayamout;

    private String contractno;

    private String bizsubkind;

    private String stagedata;

    private String checkstage;

    private String amoutsource;

    private Date expectrepaydate;

    private String practicablemsg;

    private String practicablecheckaddr;

    private String practicablestaff;

    private String loanlength;

    private Date loandate;

    private String loanpurpose;

    private String paykind;

    private String requirecheck;

    private String checked;

    private String specialrequirecheck;

    private String specialchecked;

    private String rateandintfinsercheck;

    private String rateandintfinserchecked;

    private String holdpensonrisk;

    private String managerrisk;

    private String otherrisk;

    private String checkaddr;

    private String cooperate;

    private String cooperatemsg;

    private String addrischanged;

    private String addrchangedmsg;

    private String staff;

    private String detailmsg4useamout;

    private String msgsource;

    private String useamoutbycontract;

    private String executecon;

    private String ownerstrusame;

    private String ownerstrusamemsg;

    private String msg;

    private String industrycchangsiut;

    private String industrycchangsiutmsg;

    private String mainbusischanged;

    private String mainbusischangedmsg;

    private String planexpandsitu;

    private String planexpandsitumsg;

    private String hiddentroublesitu;

    private String hiddentroublesitumsg;

    private String purchasecost;

    private String purchasecostmsg;

    private String proandopeabnormalsuit;

    private String proandopeabnormalsuitmsg;

    private String saleabnormalsuit;

    private String saleabnormalsuitmsg;

    private String chainchange;

    private String chainchangemsg;

    private String dailycostdecline;

    private String dailycostdeclinemsg;

    private String orderdecline;

    private String orderdeclinemsg;

    private String cashlasttonow;

    private String cashdecline;

    private String cashmatchesandproandope;

    private String cashothermsg;

    private String othersitu;

    private String summaryforassit;

    private String assitothersuit;

    private String summaryforcheck;

    private String inspconandsug;

    private String isadjustline;

    private String adjustline;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBizid() {
        return bizid;
    }

    public void setBizid(String bizid) {
        this.bizid = bizid == null ? null : bizid.trim();
    }

    public String getCheckflag() {
        return checkflag;
    }

    public void setCheckflag(String checkflag) {
        this.checkflag = checkflag == null ? null : checkflag.trim();
    }

    public String getEmplcode() {
        return emplcode;
    }

    public void setEmplcode(String emplcode) {
        this.emplcode = emplcode == null ? null : emplcode.trim();
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode == null ? null : orgcode.trim();
    }

    public String getOrglevel() {
        return orglevel;
    }

    public void setOrglevel(String orglevel) {
        this.orglevel = orglevel == null ? null : orglevel.trim();
    }

    public String getChecktype() {
        return checktype;
    }

    public void setChecktype(String checktype) {
        this.checktype = checktype == null ? null : checktype.trim();
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname == null ? null : custname.trim();
    }

    public String getLoanamout() {
        return loanamout;
    }

    public void setLoanamout(String loanamout) {
        this.loanamout = loanamout == null ? null : loanamout.trim();
    }

    public String getCheckmodel() {
        return checkmodel;
    }

    public void setCheckmodel(String checkmodel) {
        this.checkmodel = checkmodel == null ? null : checkmodel.trim();
    }

    public String getLineamout() {
        return lineamout;
    }

    public void setLineamout(String lineamout) {
        this.lineamout = lineamout == null ? null : lineamout.trim();
    }

    public String getYearlyinspection() {
        return yearlyinspection;
    }

    public void setYearlyinspection(String yearlyinspection) {
        this.yearlyinspection = yearlyinspection == null ? null : yearlyinspection.trim();
    }

    public String getLinebalance() {
        return linebalance;
    }

    public void setLinebalance(String linebalance) {
        this.linebalance = linebalance == null ? null : linebalance.trim();
    }

    public String getLoanbalance() {
        return loanbalance;
    }

    public void setLoanbalance(String loanbalance) {
        this.loanbalance = loanbalance == null ? null : loanbalance.trim();
    }

    public String getRevalofcoll() {
        return revalofcoll;
    }

    public void setRevalofcoll(String revalofcoll) {
        this.revalofcoll = revalofcoll == null ? null : revalofcoll.trim();
    }

    public Date getCollestimatedate() {
        return collestimatedate;
    }

    public void setCollestimatedate(Date collestimatedate) {
        this.collestimatedate = collestimatedate;
    }

    public String getCollestimatevalue() {
        return collestimatevalue;
    }

    public void setCollestimatevalue(String collestimatevalue) {
        this.collestimatevalue = collestimatevalue == null ? null : collestimatevalue.trim();
    }

    public String getCollestimatemsg() {
        return collestimatemsg;
    }

    public void setCollestimatemsg(String collestimatemsg) {
        this.collestimatemsg = collestimatemsg == null ? null : collestimatemsg.trim();
    }

    public String getSecuritykind() {
        return securitykind;
    }

    public void setSecuritykind(String securitykind) {
        this.securitykind = securitykind == null ? null : securitykind.trim();
    }

    public String getOthersecuritykindmsg() {
        return othersecuritykindmsg;
    }

    public void setOthersecuritykindmsg(String othersecuritykindmsg) {
        this.othersecuritykindmsg = othersecuritykindmsg == null ? null : othersecuritykindmsg.trim();
    }

    public String getRepaykind() {
        return repaykind;
    }

    public void setRepaykind(String repaykind) {
        this.repaykind = repaykind == null ? null : repaykind.trim();
    }

    public Date getRepaydate() {
        return repaydate;
    }

    public void setRepaydate(Date repaydate) {
        this.repaydate = repaydate;
    }

    public String getRepayamout() {
        return repayamout;
    }

    public void setRepayamout(String repayamout) {
        this.repayamout = repayamout == null ? null : repayamout.trim();
    }

    public String getContractno() {
        return contractno;
    }

    public void setContractno(String contractno) {
        this.contractno = contractno == null ? null : contractno.trim();
    }

    public String getBizsubkind() {
        return bizsubkind;
    }

    public void setBizsubkind(String bizsubkind) {
        this.bizsubkind = bizsubkind == null ? null : bizsubkind.trim();
    }

    public String getStagedata() {
        return stagedata;
    }

    public void setStagedata(String stagedata) {
        this.stagedata = stagedata == null ? null : stagedata.trim();
    }

    public String getCheckstage() {
        return checkstage;
    }

    public void setCheckstage(String checkstage) {
        this.checkstage = checkstage == null ? null : checkstage.trim();
    }

    public String getAmoutsource() {
        return amoutsource;
    }

    public void setAmoutsource(String amoutsource) {
        this.amoutsource = amoutsource == null ? null : amoutsource.trim();
    }

    public Date getExpectrepaydate() {
        return expectrepaydate;
    }

    public void setExpectrepaydate(Date expectrepaydate) {
        this.expectrepaydate = expectrepaydate;
    }

    public String getPracticablemsg() {
        return practicablemsg;
    }

    public void setPracticablemsg(String practicablemsg) {
        this.practicablemsg = practicablemsg == null ? null : practicablemsg.trim();
    }

    public String getPracticablecheckaddr() {
        return practicablecheckaddr;
    }

    public void setPracticablecheckaddr(String practicablecheckaddr) {
        this.practicablecheckaddr = practicablecheckaddr == null ? null : practicablecheckaddr.trim();
    }

    public String getPracticablestaff() {
        return practicablestaff;
    }

    public void setPracticablestaff(String practicablestaff) {
        this.practicablestaff = practicablestaff == null ? null : practicablestaff.trim();
    }

    public String getLoanlength() {
        return loanlength;
    }

    public void setLoanlength(String loanlength) {
        this.loanlength = loanlength == null ? null : loanlength.trim();
    }

    public Date getLoandate() {
        return loandate;
    }

    public void setLoandate(Date loandate) {
        this.loandate = loandate;
    }

    public String getLoanpurpose() {
        return loanpurpose;
    }

    public void setLoanpurpose(String loanpurpose) {
        this.loanpurpose = loanpurpose == null ? null : loanpurpose.trim();
    }

    public String getPaykind() {
        return paykind;
    }

    public void setPaykind(String paykind) {
        this.paykind = paykind == null ? null : paykind.trim();
    }

    public String getRequirecheck() {
        return requirecheck;
    }

    public void setRequirecheck(String requirecheck) {
        this.requirecheck = requirecheck == null ? null : requirecheck.trim();
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked == null ? null : checked.trim();
    }

    public String getSpecialrequirecheck() {
        return specialrequirecheck;
    }

    public void setSpecialrequirecheck(String specialrequirecheck) {
        this.specialrequirecheck = specialrequirecheck == null ? null : specialrequirecheck.trim();
    }

    public String getSpecialchecked() {
        return specialchecked;
    }

    public void setSpecialchecked(String specialchecked) {
        this.specialchecked = specialchecked == null ? null : specialchecked.trim();
    }

    public String getRateandintfinsercheck() {
        return rateandintfinsercheck;
    }

    public void setRateandintfinsercheck(String rateandintfinsercheck) {
        this.rateandintfinsercheck = rateandintfinsercheck == null ? null : rateandintfinsercheck.trim();
    }

    public String getRateandintfinserchecked() {
        return rateandintfinserchecked;
    }

    public void setRateandintfinserchecked(String rateandintfinserchecked) {
        this.rateandintfinserchecked = rateandintfinserchecked == null ? null : rateandintfinserchecked.trim();
    }

    public String getHoldpensonrisk() {
        return holdpensonrisk;
    }

    public void setHoldpensonrisk(String holdpensonrisk) {
        this.holdpensonrisk = holdpensonrisk == null ? null : holdpensonrisk.trim();
    }

    public String getManagerrisk() {
        return managerrisk;
    }

    public void setManagerrisk(String managerrisk) {
        this.managerrisk = managerrisk == null ? null : managerrisk.trim();
    }

    public String getOtherrisk() {
        return otherrisk;
    }

    public void setOtherrisk(String otherrisk) {
        this.otherrisk = otherrisk == null ? null : otherrisk.trim();
    }

    public String getCheckaddr() {
        return checkaddr;
    }

    public void setCheckaddr(String checkaddr) {
        this.checkaddr = checkaddr == null ? null : checkaddr.trim();
    }

    public String getCooperate() {
        return cooperate;
    }

    public void setCooperate(String cooperate) {
        this.cooperate = cooperate == null ? null : cooperate.trim();
    }

    public String getCooperatemsg() {
        return cooperatemsg;
    }

    public void setCooperatemsg(String cooperatemsg) {
        this.cooperatemsg = cooperatemsg == null ? null : cooperatemsg.trim();
    }

    public String getAddrischanged() {
        return addrischanged;
    }

    public void setAddrischanged(String addrischanged) {
        this.addrischanged = addrischanged == null ? null : addrischanged.trim();
    }

    public String getAddrchangedmsg() {
        return addrchangedmsg;
    }

    public void setAddrchangedmsg(String addrchangedmsg) {
        this.addrchangedmsg = addrchangedmsg == null ? null : addrchangedmsg.trim();
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff == null ? null : staff.trim();
    }

    public String getDetailmsg4useamout() {
        return detailmsg4useamout;
    }

    public void setDetailmsg4useamout(String detailmsg4useamout) {
        this.detailmsg4useamout = detailmsg4useamout == null ? null : detailmsg4useamout.trim();
    }

    public String getMsgsource() {
        return msgsource;
    }

    public void setMsgsource(String msgsource) {
        this.msgsource = msgsource == null ? null : msgsource.trim();
    }

    public String getUseamoutbycontract() {
        return useamoutbycontract;
    }

    public void setUseamoutbycontract(String useamoutbycontract) {
        this.useamoutbycontract = useamoutbycontract == null ? null : useamoutbycontract.trim();
    }

    public String getExecutecon() {
        return executecon;
    }

    public void setExecutecon(String executecon) {
        this.executecon = executecon == null ? null : executecon.trim();
    }

    public String getOwnerstrusame() {
        return ownerstrusame;
    }

    public void setOwnerstrusame(String ownerstrusame) {
        this.ownerstrusame = ownerstrusame == null ? null : ownerstrusame.trim();
    }

    public String getOwnerstrusamemsg() {
        return ownerstrusamemsg;
    }

    public void setOwnerstrusamemsg(String ownerstrusamemsg) {
        this.ownerstrusamemsg = ownerstrusamemsg == null ? null : ownerstrusamemsg.trim();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public String getIndustrycchangsiut() {
        return industrycchangsiut;
    }

    public void setIndustrycchangsiut(String industrycchangsiut) {
        this.industrycchangsiut = industrycchangsiut == null ? null : industrycchangsiut.trim();
    }

    public String getIndustrycchangsiutmsg() {
        return industrycchangsiutmsg;
    }

    public void setIndustrycchangsiutmsg(String industrycchangsiutmsg) {
        this.industrycchangsiutmsg = industrycchangsiutmsg == null ? null : industrycchangsiutmsg.trim();
    }

    public String getMainbusischanged() {
        return mainbusischanged;
    }

    public void setMainbusischanged(String mainbusischanged) {
        this.mainbusischanged = mainbusischanged == null ? null : mainbusischanged.trim();
    }

    public String getMainbusischangedmsg() {
        return mainbusischangedmsg;
    }

    public void setMainbusischangedmsg(String mainbusischangedmsg) {
        this.mainbusischangedmsg = mainbusischangedmsg == null ? null : mainbusischangedmsg.trim();
    }

    public String getPlanexpandsitu() {
        return planexpandsitu;
    }

    public void setPlanexpandsitu(String planexpandsitu) {
        this.planexpandsitu = planexpandsitu == null ? null : planexpandsitu.trim();
    }

    public String getPlanexpandsitumsg() {
        return planexpandsitumsg;
    }

    public void setPlanexpandsitumsg(String planexpandsitumsg) {
        this.planexpandsitumsg = planexpandsitumsg == null ? null : planexpandsitumsg.trim();
    }

    public String getHiddentroublesitu() {
        return hiddentroublesitu;
    }

    public void setHiddentroublesitu(String hiddentroublesitu) {
        this.hiddentroublesitu = hiddentroublesitu == null ? null : hiddentroublesitu.trim();
    }

    public String getHiddentroublesitumsg() {
        return hiddentroublesitumsg;
    }

    public void setHiddentroublesitumsg(String hiddentroublesitumsg) {
        this.hiddentroublesitumsg = hiddentroublesitumsg == null ? null : hiddentroublesitumsg.trim();
    }

    public String getPurchasecost() {
        return purchasecost;
    }

    public void setPurchasecost(String purchasecost) {
        this.purchasecost = purchasecost == null ? null : purchasecost.trim();
    }

    public String getPurchasecostmsg() {
        return purchasecostmsg;
    }

    public void setPurchasecostmsg(String purchasecostmsg) {
        this.purchasecostmsg = purchasecostmsg == null ? null : purchasecostmsg.trim();
    }

    public String getProandopeabnormalsuit() {
        return proandopeabnormalsuit;
    }

    public void setProandopeabnormalsuit(String proandopeabnormalsuit) {
        this.proandopeabnormalsuit = proandopeabnormalsuit == null ? null : proandopeabnormalsuit.trim();
    }

    public String getProandopeabnormalsuitmsg() {
        return proandopeabnormalsuitmsg;
    }

    public void setProandopeabnormalsuitmsg(String proandopeabnormalsuitmsg) {
        this.proandopeabnormalsuitmsg = proandopeabnormalsuitmsg == null ? null : proandopeabnormalsuitmsg.trim();
    }

    public String getSaleabnormalsuit() {
        return saleabnormalsuit;
    }

    public void setSaleabnormalsuit(String saleabnormalsuit) {
        this.saleabnormalsuit = saleabnormalsuit == null ? null : saleabnormalsuit.trim();
    }

    public String getSaleabnormalsuitmsg() {
        return saleabnormalsuitmsg;
    }

    public void setSaleabnormalsuitmsg(String saleabnormalsuitmsg) {
        this.saleabnormalsuitmsg = saleabnormalsuitmsg == null ? null : saleabnormalsuitmsg.trim();
    }

    public String getChainchange() {
        return chainchange;
    }

    public void setChainchange(String chainchange) {
        this.chainchange = chainchange == null ? null : chainchange.trim();
    }

    public String getChainchangemsg() {
        return chainchangemsg;
    }

    public void setChainchangemsg(String chainchangemsg) {
        this.chainchangemsg = chainchangemsg == null ? null : chainchangemsg.trim();
    }

    public String getDailycostdecline() {
        return dailycostdecline;
    }

    public void setDailycostdecline(String dailycostdecline) {
        this.dailycostdecline = dailycostdecline == null ? null : dailycostdecline.trim();
    }

    public String getDailycostdeclinemsg() {
        return dailycostdeclinemsg;
    }

    public void setDailycostdeclinemsg(String dailycostdeclinemsg) {
        this.dailycostdeclinemsg = dailycostdeclinemsg == null ? null : dailycostdeclinemsg.trim();
    }

    public String getOrderdecline() {
        return orderdecline;
    }

    public void setOrderdecline(String orderdecline) {
        this.orderdecline = orderdecline == null ? null : orderdecline.trim();
    }

    public String getOrderdeclinemsg() {
        return orderdeclinemsg;
    }

    public void setOrderdeclinemsg(String orderdeclinemsg) {
        this.orderdeclinemsg = orderdeclinemsg == null ? null : orderdeclinemsg.trim();
    }

    public String getCashlasttonow() {
        return cashlasttonow;
    }

    public void setCashlasttonow(String cashlasttonow) {
        this.cashlasttonow = cashlasttonow == null ? null : cashlasttonow.trim();
    }

    public String getCashdecline() {
        return cashdecline;
    }

    public void setCashdecline(String cashdecline) {
        this.cashdecline = cashdecline == null ? null : cashdecline.trim();
    }

    public String getCashmatchesandproandope() {
        return cashmatchesandproandope;
    }

    public void setCashmatchesandproandope(String cashmatchesandproandope) {
        this.cashmatchesandproandope = cashmatchesandproandope == null ? null : cashmatchesandproandope.trim();
    }

    public String getCashothermsg() {
        return cashothermsg;
    }

    public void setCashothermsg(String cashothermsg) {
        this.cashothermsg = cashothermsg == null ? null : cashothermsg.trim();
    }

    public String getOthersitu() {
        return othersitu;
    }

    public void setOthersitu(String othersitu) {
        this.othersitu = othersitu == null ? null : othersitu.trim();
    }

    public String getSummaryforassit() {
        return summaryforassit;
    }

    public void setSummaryforassit(String summaryforassit) {
        this.summaryforassit = summaryforassit == null ? null : summaryforassit.trim();
    }

    public String getAssitothersuit() {
        return assitothersuit;
    }

    public void setAssitothersuit(String assitothersuit) {
        this.assitothersuit = assitothersuit == null ? null : assitothersuit.trim();
    }

    public String getSummaryforcheck() {
        return summaryforcheck;
    }

    public void setSummaryforcheck(String summaryforcheck) {
        this.summaryforcheck = summaryforcheck == null ? null : summaryforcheck.trim();
    }

    public String getInspconandsug() {
        return inspconandsug;
    }

    public void setInspconandsug(String inspconandsug) {
        this.inspconandsug = inspconandsug == null ? null : inspconandsug.trim();
    }

    public String getIsadjustline() {
        return isadjustline;
    }

    public void setIsadjustline(String isadjustline) {
        this.isadjustline = isadjustline == null ? null : isadjustline.trim();
    }

    public String getAdjustline() {
        return adjustline;
    }

    public void setAdjustline(String adjustline) {
        this.adjustline = adjustline == null ? null : adjustline.trim();
    }
}