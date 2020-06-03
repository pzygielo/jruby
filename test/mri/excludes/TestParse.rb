exclude :test_error_def_in_argument, "provides different syntax errors"
exclude :test_invalid_char, "needs investigation"
exclude :test_literal_in_conditional, "flip-flop case raises because do not implement flip-flop"
exclude :test_location_of_invalid_token, "not implemented, #6159"
exclude :test_lparenarg, "space issue with parens in really weird syntax"
exclude :test_method_block_location, "needs investigation"
exclude :test_method_location_in_rescue, "parser updates corrected defs to use first line"
exclude :test_negative_line_number, "JVM emits negative like some overflow (interp fine)"
exclude :test_question, "needs investigation"
exclude :test_rescue_in_command_assignment, "needs investigation"
exclude :test_string, "lots of very specific error messages in which we differ a little"
exclude :test_truncated_source_line, "2.5 truncates long source lines...we dont yet"
exclude :test_unexpected_token_after_numeric, "More strict parsing of text immediately after numbers"
exclude :test_unused_variable, "missing warning in parser (#2147)"
