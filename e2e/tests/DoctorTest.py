import unittest

from .utils import *

class DoctorTest(unittest.TestCase):

    def setUp(self):
        self.driver = get_driver()
        login(self.driver, "doctor@office.com", "XXX")


    def tearDown(self):
        self.driver.close()
        
    def test_basic(self):
        self.driver.find_element_by_link_text("Patients").click()
        time.sleep(3)
        self.driver.find_element_by_xpath('//*[@id="insurance"]/a').click()
        time.sleep(3)
        self.driver.find_elements_by_tag_name("button")[-1].click()
        logout(self.driver)
        login(self.driver, "clinic_admin@office.com", "XXX")
        self.driver.find_element_by_link_text("Cares").click()
        time.sleep(2)
        elems = self.driver.find_elements_by_xpath('//*[@id="reservate"]/div[1]/button')
        for elem in elems:
            if elem.text.lower() == "select room":
                elem.click()
                break
        
                