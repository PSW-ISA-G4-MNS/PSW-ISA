import unittest

from .utils import *

class DoctorTest(unittest.TestCase):

    def setUp(self):
        self.driver = get_driver()
        login(self.driver, "doctor@office.com", "XXX")


    def tearDown(self):
        self.driver.close()
        
    def test_basic(self):
        self.assertEqual(2+2, 4)
        