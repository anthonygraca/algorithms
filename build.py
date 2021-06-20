#   -*- coding: utf-8 -*-
from pybuilder.core import use_plugin, init

use_plugin("python.core")
use_plugin("python.unittest")
use_plugin("python.flake8")
use_plugin("python.coverage")
use_plugin("python.distutils")


name = "algorithms"
default_task = "publish"


@init
def set_properties(project):
    project.set_property("dir_source_unittest_python", "src/test/python")
    project.build_depends_on("mockito")
