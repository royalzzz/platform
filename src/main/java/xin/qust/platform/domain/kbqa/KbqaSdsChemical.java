package xin.qust.platform.domain.kbqa;

import javax.persistence.*;

@Entity
@Table(name = "kbqa_sds_chemical")
public class KbqaSdsChemical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* 化学品唯一CAS编号 */
    @Lob
    @Column(columnDefinition="text")
    private String cas;

    /* 中文名称 */
    @Lob
    @Column(columnDefinition="text")
    private String chineseName;

    /* 其他中文名称 */
    @Lob
    @Column(columnDefinition="text")
    private String otherChineseName;

    /* 英文名称 */
    @Lob
    @Column(columnDefinition="text")
    private String englishName;

    /* 其他英文名称 */
    @Lob
    @Column(columnDefinition="text")
    private String otherEnglishName;

    /* 化学分子式 Molecular Formula */
    @Lob
    @Column(columnDefinition="text")
    private String MF;

    /* 化学分子量 Molecular Weight */
    @Lob
    @Column(columnDefinition="text")
    private String MW;

    /* UN 编号 */
    @Lob
    @Column(columnDefinition="text")
    private String UN;

    /* 颜色 / 形态 */
    @Lob
    @Column(columnDefinition="text")
    private String shape;

    /* 气味 */
    @Lob
    @Column(columnDefinition="text")
    private String smell;

    /* 味道 */
    @Lob
    @Column(columnDefinition="text")
    private String taste;

    /* PH 值 */
    @Lob
    @Column(columnDefinition="text")
    private String ph;

    /* 熔点 */
    @Lob
    @Column(columnDefinition="text")
    private String meltingPoint;

    /* 相对密度 （水 = 1）*/
    @Lob
    @Column(columnDefinition="text")
    private String relativeDensity;

    /* 蒸汽相对密度 （空气 = 1） */
    @Lob
    @Column(columnDefinition="text")
    private String vaporRelativeDensity;

    /* 饱和蒸汽压 kPa */
    @Lob
    @Column(columnDefinition="text")
    private String saturatedVaporPressure;

    /* 沸点 */
    @Lob
    @Column(columnDefinition="text")
    private String boilingPoint;

    /* 燃烧热 (kj/mol) */
    @Lob
    @Column(columnDefinition="text")
    private String combustionHeat;

    /* 临界温度 */
    @Lob
    @Column(columnDefinition="text")
    private String thresholdTemperature;

    /* 临界压力 */
    @Lob
    @Column(columnDefinition="text")
    private String thresholdPressure;

    /* 闪点 */
    @Lob
    @Column(columnDefinition="text")
    private String flashPoint;

    /* 引燃温度 */
    @Lob
    @Column(columnDefinition="text")
    private String ignitionTemperature;

    /* 爆炸下限[%(V/V)] low explosive limit */
    @Lob
    @Column(columnDefinition="text")
    private String lel;

    /* 爆炸上限[%(V/V)] upper explosive limit */
    @Lob
    @Column(columnDefinition="text")
    private String uel;

    /* 辛醇/水分配系数 Octanol-Water Partition Coefficient, Kow */
    @Lob
    @Column(columnDefinition="text")
    private String kow;

    /* 溶解性 */
    @Lob
    @Column(columnDefinition="text")
    private String solubility;

    /* 化学性质 */
    @Lob
    @Column(columnDefinition="text")
    private String chemicalProperty;

    /* 危害性类别 */
    @Lob
    @Column(columnDefinition="text")
    private String hazardCategory;

    /* 健康危害级别 */
    @Lob
    @Column(columnDefinition="text")
    private String healthHazardLevel;

    /* 可燃性级别 */
    @Lob
    @Column(columnDefinition="text")
    private String flammabilityLevel;

    /* 反应活性级别 */
    @Lob
    @Column(columnDefinition="text")
    private String reactivityLevel;

    /* 特殊危害性 */
    @Lob
    @Column(columnDefinition="text")
    private String specialHazard;

    /* 燃爆危害 */
    @Lob
    @Column(columnDefinition="text")
    private String explosionHazard;

    /* 健康危害 */
    @Lob
    @Column(columnDefinition="text")
    private String healthHazard;

    /* 入侵途径 */
    @Lob
    @Column(columnDefinition="text")
    private String invasionMethod;

    /* 环境危害 */
    @Lob
    @Column(columnDefinition="text")
    private String environmentalHazards;

    /* 生产过程中的危险 */
    @Lob
    @Column(columnDefinition="text")
    private String productionProcessDangers;

    /* 生产方法 */
    @Lob
    @Column(columnDefinition="text")
    private String productionMethod;

    /* 用途 */
    @Lob
    @Column(columnDefinition="text")
    private String application;

    /* 吸入接触 */
    @Lob
    @Column(columnDefinition="text")
    private String inhalationContact;

    /* 食入 */
    @Lob
    @Column(columnDefinition="text")
    private String ingestion;

    /* 眼睛接触 */
    @Lob
    @Column(columnDefinition="text")
    private String eyeContact;

    /* 皮肤接触 */
    @Lob
    @Column(columnDefinition="text")
    private String skinContact;

    /* 灭火方法 */
    @Lob
    @Column(columnDefinition="text")
    private String fireFightingMethods;

    /* 灭火剂 */
    @Lob
    @Column(columnDefinition="text")
    private String extinguishingAgent;

    /* 泄露处理 */
    @Lob
    @Column(columnDefinition="text")
    private String leakHandling;

    /* 隔离与疏散距离 */
    @Lob
    @Column(columnDefinition="text")
    private String isolationAndEvacuationDistance;

    /* 应急人员个体防护 */
    @Lob
    @Column(columnDefinition="text")
    private String personalProtectionForEmergencyPersonnel;

    /* 泄露控制 */
    @Lob
    @Column(columnDefinition="text")
    private String leakControl;

    /* 废弃处置方法 */
    @Lob
    @Column(columnDefinition="text")
    private String disposalMethods;

    /* 急性毒性 */
    @Lob
    @Column(columnDefinition="text")
    private String acuteToxicity;

    /* LD50 */
    @Lob
    @Column(columnDefinition="text")
    private String ld50;

    /* LC50 */
    @Lob
    @Column(columnDefinition="text")
    private String lc50;

    /* 刺激性 */
    @Lob
    @Column(columnDefinition="text")
    private String irritating;

    /* 亚急性与慢性毒性 */
    @Lob
    @Column(columnDefinition="text")
    private String subacuteAndChronicToxicity;

    /* 致敏性 */
    @Lob
    @Column(columnDefinition="text")
    private String sensitization;

    /* 致突变性 */
    @Lob
    @Column(columnDefinition="text")
    private String mutagenicity;

    /* 致畸性 */
    @Lob
    @Column(columnDefinition="text")
    private String teratogenicity;

    /* 致癌性 */
    @Lob
    @Column(columnDefinition="text")
    private String carcinogenicity;

    /* 其他毒理作用 */
    @Lob
    @Column(columnDefinition="text")
    private String otherToxicologicalEffects;

    /* PC-TWA */
    @Lob
    @Column(columnDefinition="text")
    private String pc_twa;

    /* PC-STEL */
    @Lob
    @Column(columnDefinition="text")
    private String pc_stel;

    /* MAC */
    @Lob
    @Column(columnDefinition="text")
    private String mac;

    /* 立即威胁生命 */
    @Lob
    @Column(columnDefinition="text")
    private String threatenLifeImmediately;

    /* TLV-TWA */
    @Lob
    @Column(columnDefinition="text")
    private String tlv_twa;

    /* TLV-STEL */
    @Lob
    @Column(columnDefinition="text")
    private String tlv_stel;

    /* 眼睛防护 */
    @Lob
    @Column(columnDefinition="text")
    private String eyeProtection;

    /* 皮肤防护 */
    @Lob
    @Column(columnDefinition="text")
    private String skinProtection;

    /* 呼吸防护 */
    @Lob
    @Column(columnDefinition="text")
    private String respiratoryProtection;

    /* 其他防护 */
    @Lob
    @Column(columnDefinition="text")
    private String otherProtection;

    /* 运输方式 */
    @Lob
    @Column(columnDefinition="text")
    private String modeOfTransport;

    /* 容器 */
    @Lob
    @Column(columnDefinition="text")
    private String container;

    /* 包装类别 */
    @Lob
    @Column(columnDefinition="text")
    private String packingCategory;

    /* 包装标志*/
    @Lob
    @Column(columnDefinition="text")
    private String packagingLogo;

    /* 运输注意事项 */
    @Lob
    @Column(columnDefinition="text")
    private String transportationConsiderations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCas() {
        return cas;
    }

    public void setCas(String cas) {
        this.cas = cas;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getOtherChineseName() {
        return otherChineseName;
    }

    public void setOtherChineseName(String otherChineseName) {
        this.otherChineseName = otherChineseName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getOtherEnglishName() {
        return otherEnglishName;
    }

    public void setOtherEnglishName(String otherEnglishName) {
        this.otherEnglishName = otherEnglishName;
    }

    public String getMF() {
        return MF;
    }

    public void setMF(String MF) {
        this.MF = MF;
    }

    public String getMW() {
        return MW;
    }

    public void setMW(String MW) {
        this.MW = MW;
    }

    public String getUN() {
        return UN;
    }

    public void setUN(String UN) {
        this.UN = UN;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getSmell() {
        return smell;
    }

    public void setSmell(String smell) {
        this.smell = smell;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getMeltingPoint() {
        return meltingPoint;
    }

    public void setMeltingPoint(String meltingPoint) {
        this.meltingPoint = meltingPoint;
    }

    public String getRelativeDensity() {
        return relativeDensity;
    }

    public void setRelativeDensity(String relativeDensity) {
        this.relativeDensity = relativeDensity;
    }

    public String getVaporRelativeDensity() {
        return vaporRelativeDensity;
    }

    public void setVaporRelativeDensity(String vaporRelativeDensity) {
        this.vaporRelativeDensity = vaporRelativeDensity;
    }

    public String getSaturatedVaporPressure() {
        return saturatedVaporPressure;
    }

    public void setSaturatedVaporPressure(String saturatedVaporPressure) {
        this.saturatedVaporPressure = saturatedVaporPressure;
    }

    public String getBoilingPoint() {
        return boilingPoint;
    }

    public void setBoilingPoint(String boilingPoint) {
        this.boilingPoint = boilingPoint;
    }

    public String getCombustionHeat() {
        return combustionHeat;
    }

    public void setCombustionHeat(String combustionHeat) {
        this.combustionHeat = combustionHeat;
    }

    public String getThresholdTemperature() {
        return thresholdTemperature;
    }

    public void setThresholdTemperature(String thresholdTemperature) {
        this.thresholdTemperature = thresholdTemperature;
    }

    public String getThresholdPressure() {
        return thresholdPressure;
    }

    public void setThresholdPressure(String thresholdPressure) {
        this.thresholdPressure = thresholdPressure;
    }

    public String getFlashPoint() {
        return flashPoint;
    }

    public void setFlashPoint(String flashPoint) {
        this.flashPoint = flashPoint;
    }

    public String getIgnitionTemperature() {
        return ignitionTemperature;
    }

    public void setIgnitionTemperature(String ignitionTemperature) {
        this.ignitionTemperature = ignitionTemperature;
    }

    public String getLel() {
        return lel;
    }

    public void setLel(String lel) {
        this.lel = lel;
    }

    public String getUel() {
        return uel;
    }

    public void setUel(String uel) {
        this.uel = uel;
    }

    public String getKow() {
        return kow;
    }

    public void setKow(String kow) {
        this.kow = kow;
    }

    public String getSolubility() {
        return solubility;
    }

    public void setSolubility(String solubility) {
        this.solubility = solubility;
    }

    public String getChemicalProperty() {
        return chemicalProperty;
    }

    public void setChemicalProperty(String chemicalProperty) {
        this.chemicalProperty = chemicalProperty;
    }

    public String getHazardCategory() {
        return hazardCategory;
    }

    public void setHazardCategory(String hazardCategory) {
        this.hazardCategory = hazardCategory;
    }

    public String getHealthHazardLevel() {
        return healthHazardLevel;
    }

    public void setHealthHazardLevel(String healthHazardLevel) {
        this.healthHazardLevel = healthHazardLevel;
    }

    public String getFlammabilityLevel() {
        return flammabilityLevel;
    }

    public void setFlammabilityLevel(String flammabilityLevel) {
        this.flammabilityLevel = flammabilityLevel;
    }

    public String getReactivityLevel() {
        return reactivityLevel;
    }

    public void setReactivityLevel(String reactivityLevel) {
        this.reactivityLevel = reactivityLevel;
    }

    public String getSpecialHazard() {
        return specialHazard;
    }

    public void setSpecialHazard(String specialHazard) {
        this.specialHazard = specialHazard;
    }

    public String getExplosionHazard() {
        return explosionHazard;
    }

    public void setExplosionHazard(String explosionHazard) {
        this.explosionHazard = explosionHazard;
    }

    public String getHealthHazard() {
        return healthHazard;
    }

    public void setHealthHazard(String healthHazard) {
        this.healthHazard = healthHazard;
    }

    public String getInvasionMethod() {
        return invasionMethod;
    }

    public void setInvasionMethod(String invasionMethod) {
        this.invasionMethod = invasionMethod;
    }

    public String getEnvironmentalHazards() {
        return environmentalHazards;
    }

    public void setEnvironmentalHazards(String environmentalHazards) {
        this.environmentalHazards = environmentalHazards;
    }

    public String getProductionProcessDangers() {
        return productionProcessDangers;
    }

    public void setProductionProcessDangers(String productionProcessDangers) {
        this.productionProcessDangers = productionProcessDangers;
    }

    public String getProductionMethod() {
        return productionMethod;
    }

    public void setProductionMethod(String productionMethod) {
        this.productionMethod = productionMethod;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getInhalationContact() {
        return inhalationContact;
    }

    public void setInhalationContact(String inhalationContact) {
        this.inhalationContact = inhalationContact;
    }

    public String getIngestion() {
        return ingestion;
    }

    public void setIngestion(String ingestion) {
        this.ingestion = ingestion;
    }

    public String getEyeContact() {
        return eyeContact;
    }

    public void setEyeContact(String eyeContact) {
        this.eyeContact = eyeContact;
    }

    public String getSkinContact() {
        return skinContact;
    }

    public void setSkinContact(String skinContact) {
        this.skinContact = skinContact;
    }

    public String getFireFightingMethods() {
        return fireFightingMethods;
    }

    public void setFireFightingMethods(String fireFightingMethods) {
        this.fireFightingMethods = fireFightingMethods;
    }

    public String getExtinguishingAgent() {
        return extinguishingAgent;
    }

    public void setExtinguishingAgent(String extinguishingAgent) {
        this.extinguishingAgent = extinguishingAgent;
    }

    public String getLeakHandling() {
        return leakHandling;
    }

    public void setLeakHandling(String leakHandling) {
        this.leakHandling = leakHandling;
    }

    public String getIsolationAndEvacuationDistance() {
        return isolationAndEvacuationDistance;
    }

    public void setIsolationAndEvacuationDistance(String isolationAndEvacuationDistance) {
        this.isolationAndEvacuationDistance = isolationAndEvacuationDistance;
    }

    public String getPersonalProtectionForEmergencyPersonnel() {
        return personalProtectionForEmergencyPersonnel;
    }

    public void setPersonalProtectionForEmergencyPersonnel(String personalProtectionForEmergencyPersonnel) {
        this.personalProtectionForEmergencyPersonnel = personalProtectionForEmergencyPersonnel;
    }

    public String getLeakControl() {
        return leakControl;
    }

    public void setLeakControl(String leakControl) {
        this.leakControl = leakControl;
    }

    public String getDisposalMethods() {
        return disposalMethods;
    }

    public void setDisposalMethods(String disposalMethods) {
        this.disposalMethods = disposalMethods;
    }

    public String getAcuteToxicity() {
        return acuteToxicity;
    }

    public void setAcuteToxicity(String acuteToxicity) {
        this.acuteToxicity = acuteToxicity;
    }

    public String getLd50() {
        return ld50;
    }

    public void setLd50(String ld50) {
        this.ld50 = ld50;
    }

    public String getLc50() {
        return lc50;
    }

    public void setLc50(String lc50) {
        this.lc50 = lc50;
    }

    public String getIrritating() {
        return irritating;
    }

    public void setIrritating(String irritating) {
        this.irritating = irritating;
    }

    public String getSubacuteAndChronicToxicity() {
        return subacuteAndChronicToxicity;
    }

    public void setSubacuteAndChronicToxicity(String subacuteAndChronicToxicity) {
        this.subacuteAndChronicToxicity = subacuteAndChronicToxicity;
    }

    public String getSensitization() {
        return sensitization;
    }

    public void setSensitization(String sensitization) {
        this.sensitization = sensitization;
    }

    public String getMutagenicity() {
        return mutagenicity;
    }

    public void setMutagenicity(String mutagenicity) {
        this.mutagenicity = mutagenicity;
    }

    public String getTeratogenicity() {
        return teratogenicity;
    }

    public void setTeratogenicity(String teratogenicity) {
        this.teratogenicity = teratogenicity;
    }

    public String getCarcinogenicity() {
        return carcinogenicity;
    }

    public void setCarcinogenicity(String carcinogenicity) {
        this.carcinogenicity = carcinogenicity;
    }

    public String getOtherToxicologicalEffects() {
        return otherToxicologicalEffects;
    }

    public void setOtherToxicologicalEffects(String otherToxicologicalEffects) {
        this.otherToxicologicalEffects = otherToxicologicalEffects;
    }

    public String getPc_twa() {
        return pc_twa;
    }

    public void setPc_twa(String pc_twa) {
        this.pc_twa = pc_twa;
    }

    public String getPc_stel() {
        return pc_stel;
    }

    public void setPc_stel(String pc_stel) {
        this.pc_stel = pc_stel;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getThreatenLifeImmediately() {
        return threatenLifeImmediately;
    }

    public void setThreatenLifeImmediately(String threatenLifeImmediately) {
        this.threatenLifeImmediately = threatenLifeImmediately;
    }

    public String getTlv_twa() {
        return tlv_twa;
    }

    public void setTlv_twa(String tlv_twa) {
        this.tlv_twa = tlv_twa;
    }

    public String getTlv_stel() {
        return tlv_stel;
    }

    public void setTlv_stel(String tlv_stel) {
        this.tlv_stel = tlv_stel;
    }

    public String getEyeProtection() {
        return eyeProtection;
    }

    public void setEyeProtection(String eyeProtection) {
        this.eyeProtection = eyeProtection;
    }

    public String getSkinProtection() {
        return skinProtection;
    }

    public void setSkinProtection(String skinProtection) {
        this.skinProtection = skinProtection;
    }

    public String getRespiratoryProtection() {
        return respiratoryProtection;
    }

    public void setRespiratoryProtection(String respiratoryProtection) {
        this.respiratoryProtection = respiratoryProtection;
    }

    public String getOtherProtection() {
        return otherProtection;
    }

    public void setOtherProtection(String otherProtection) {
        this.otherProtection = otherProtection;
    }

    public String getModeOfTransport() {
        return modeOfTransport;
    }

    public void setModeOfTransport(String modeOfTransport) {
        this.modeOfTransport = modeOfTransport;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getPackingCategory() {
        return packingCategory;
    }

    public void setPackingCategory(String packingCategory) {
        this.packingCategory = packingCategory;
    }

    public String getPackagingLogo() {
        return packagingLogo;
    }

    public void setPackagingLogo(String packagingLogo) {
        this.packagingLogo = packagingLogo;
    }

    public String getTransportationConsiderations() {
        return transportationConsiderations;
    }

    public void setTransportationConsiderations(String transportationConsiderations) {
        this.transportationConsiderations = transportationConsiderations;
    }
}
