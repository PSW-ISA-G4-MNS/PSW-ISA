import unittest
import time 
from .utils import *

class ClinicAdminTest(unittest.TestCase):
    def setUp(self):
        self.driver = get_driver()
        login(self.driver, "clinic_admin@office.com", "XXX")

    def tearDown(self):
        logout(self.driver)
        self.driver.close()
    
    
    def test_basic(self):
        logout(self.driver)
        login(self.driver, "doctor@office.com", "XXX")
        self.driver.find_element_by_link_text("Patients").click()
        time.sleep(3)
        self.driver.find_element_by_xpath('//*[@id="insurance"]/a').click()
        time.sleep(3)
        self.driver.find_elements_by_tag_name("button")[-1].click()
        logout(self.driver)
        login(self.driver, "clinic_admin@office.com", "XXX")
        self.driver.find_element_by_link_text("Cares").click()
        time.sleep(2)
        self.assertGreaterEqual(len(self.driver.find_elements_by_xpath('//*[@id="reservate"]/div[1]/button')), 3)
        