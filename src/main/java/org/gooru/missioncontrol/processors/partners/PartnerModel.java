
package org.gooru.missioncontrol.processors.partners;

import java.util.UUID;

/**
 * @author szgooru Created On 02-Jul-2019
 */
public class PartnerModel {

  private Long id;
  private String organizationName;
  private String partnerType;
  private UUID tenant;
  private UUID partner;
  private String website;
  private String logo;
  private Long[] countries;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getOrganizationName() {
    return organizationName;
  }

  public void setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
  }

  public String getPartnerType() {
    return partnerType;
  }

  public void setPartnerType(String partnerType) {
    this.partnerType = partnerType;
  }

  public UUID getTenant() {
    return tenant;
  }

  public void setTenant(UUID tenant) {
    this.tenant = tenant;
  }

  public UUID getPartner() {
    return partner;
  }

  public void setPartner(UUID partner) {
    this.partner = partner;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }
  
  public String getLogo() {
    return logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }

  public Long[] getCountries() {
    return countries;
  }

  public void setCountries(Long[] countries) {
    this.countries = countries;
  }
  
}
